package com.lifotech.scala.impatient.ch01

object Chapter01 {

  /**
    * Question 6: Using BigInt, compute 21024.
    */
  def compute(base: Int, pow: Int): BigInt = BigInt(base).pow(pow)


  /**
    * Question 7. What do you need to import so that you can get a random prime as probablePrime(100, Random),
    * without any qualifiers before probablePrime and Random?
    */
  def randomPrime(): BigInt = {

    import scala.util.Random
    import scala.math.BigInt.probablePrime

    probablePrime(100, Random)
  }

  /**
    * Question 8: One way to create random file or directory names is to produce a random BigInt
    * and convert it to base 36, yielding a string such as "qsnvbevtomcj38o06kul".
    * Poke around Scaladoc to find a way of doing this in Scala.
    */
  def randomFileName: String = randomPrime().toString(32)


  /**
    * Question 9 & 10 . How do you get the first character of a string in Scala? The last character?
    */
  def firstCharacter(str: String): Char = str.head

  def lastCharacter(str: String): Char = str.last


}
