package com.lifotech.scala.impatient.ch07

object PasswordReader extends App {


  println(greetMessage)

  import java.lang.{System, _}

  val userName = System.getProperty("user.name")

  print("please enter password")
  val pass = scala.io.StdIn.readLine()

  if (pass == "secret") println(s"you are wellcome")
  else println("password in incorrect")


}
