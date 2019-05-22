package com.lifotech.scala.impatient.ch02

object Chapter02 {


  /*
  Question 1. The signum of a number is 1 if the number is positive, –1 if it is negative, and 0 if it is zero.
  Write a function that computes this value.
   */
  def sigNum(number: Int): Int = if (number > 0) 1 else if (number < 0) -1 else 0

  def sigNumUsingPatternMatching(number: Int): Int = number match {
    case number if (number > 0) => 1
    case number if (number < 0) => -1
    case _ => 0
  }


  // Question 2. What is the value of an empty block expression {}? What is its type?

  // Answer: () and its type is Unit


  // Question 3. Come up with one situation where the assignment x = y = 1 is valid in Scala.
  // (Hint: Pick a suitable type for x.)

  // Answer:   scala> var x: Unit =()
  //        x: Unit = ()

  //        scala> x = y = 1
  //        x: Unit = ()

  // Question 4.     Write a Scala equivalent for the Java loop
  //for (int i = 10; i >= 0; i--) System.out.println(i);


  def scalaEqvivalentLoop() = {
    for (i <- 10 to 0 by -1) println(i)
  }

  // Question 5. Write a procedure countdown(n: Int) that prints the numbers from n to 0.
  def countDown(n: Int) {
    for (i <- n to 0 by -1) println(i)
  }


  //Question 6. Write a for loop for computing the product of the Unicode codes of all letters in a string.
  // For example, the product of the characters in "Hello" is 9415087488L.
  def productOfUnicode(string: String): BigInt = {
    var result: BigInt = 1
    for (ch <- string) result *= BigInt(ch)
    result
  }

  //Question 7. Write a for loop for computing the product of the Unicode codes of all letters in a string.
  // For example, the product of the characters in "Hello" is 9415087488L.
  // Write without Loop
  def productOfUnicodeWithoutLoop(string: String): BigInt = string.map(BigInt(_)).product


  // Question 8: Write a function product(s : String) that computes the product, as described in the preceding exercises.
  def product(s: String): BigInt = s.map(BigInt(_)).reduce((x, y) => x * y)

  // Question 9: Make the function of the preceding exercise a recursive function.

  def productRec(s: String): BigInt = {
    if (s.length == 0) 1
    else BigInt(s.head) * productRec(s.tail)
  }


  // Question 10. Write a function that computes xn, where n is an integer.
  // Use the following recursive definition:
  // • x^n = y . y if n is even and positive, where y = x^n / 2.
  // • x^n = x·x^n – 1 if n is odd and positive.
  // • x^0 = 1. • x^n = 1 / x^–n if n is negative. Don’t use a return statement.

  def computeXPowN(x: Int, n: Int): BigInt = n match {
    case n if (n % 2 == 0 && n > 0) => BigInt(x).pow(n / 2) * BigInt(x).pow(n / 2)
    case n if (n % 2 != 0 && n > 0) => BigInt(x) * BigInt(x).pow(n - 1)
    case n if (n < 0) => 1 / BigInt(x).pow(-n)
  }


}
