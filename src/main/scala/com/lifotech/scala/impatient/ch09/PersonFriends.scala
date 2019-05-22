package com.lifotech.scala.impatient.ch09

case class PersonFriends(person: Person, friends: Array[Person])


case class Person(name: String)


object PersonFriends {

  def saveFriendsToFile(personFriends: PersonFriends, file: String): Unit = {
    import java.io.{File, FileOutputStream, ObjectOutputStream}
    val fos: FileOutputStream = new FileOutputStream(new File(file))

    val oos: ObjectOutputStream = new ObjectOutputStream(fos)
    oos.writeObject(personFriends)

    oos.close()

  }

  def readFriendsFile(file: String): AnyRef = {
    import java.io.{File, FileInputStream, FileOutputStream, ObjectInputStream, ObjectOutputStream}
    val fis: FileInputStream = new FileInputStream(new File(file))

    val ois: ObjectInputStream = new ObjectInputStream(fis)

    ois.readObject()


  }

  def main(args: Array[String]): Unit = {

    val sk = Person("John")
    val rk = Person("Tom")
    val nk = Person("Jimmy")

    val personFriends = PersonFriends(sk, Array(rk,nk))

    PersonFriends.saveFriendsToFile(personFriends, "./personFriends")

    val personFriendsFromFile = PersonFriends.readFriendsFile("./personFriends")

    print(personFriendsFromFile.toString)

  }
}