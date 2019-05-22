package com.lifotech.scala.impatient.ch12

import org.scalatest.{BeforeAndAfter, BeforeAndAfterAll, FlatSpec, Matchers}


class Class12 extends FlatSpec with Matchers with BeforeAndAfter with BeforeAndAfterAll {


  "Exercise 1 " should "yields a collection of function inputs and outputs in a given range" in {

    def values(f: Int => Int, low: Int, high: Int): Seq[(Int, Int)] = for (i <- low to high) yield (i, f(i))

    val result = values(x => x * x, -2, 2)
    val expectedResult = Seq((-2, 4), (-1, 1), (0, 0), (1, 1), (2, 4))

    assert(expectedResult === result)
  }

  "Exercise 2" should "return largest element of an array" in {
    def largestElement(array: Array[Int]): Int = array.reduceLeft((x, y) => if (x > y) x else y)

    val result = largestElement(Array(45, 56, 220, 112))

    assert(220 === result)
  }

  "Exercise 3" should "implement the factorial function using to and reduceLeft, without a loop or recursion." in {

    def fact(n: Int): Int = {
      if (n < 1) 1
      else (n to 1 by -1).reduceLeft(_ * _)
    }

    val result = fact(5)

    assert(120 == result)
  }


  //5. Write a function largest(fun: (Int) => Int, inputs: Seq[Int]) that yields the largest value of a function within a given sequence of inputs. For example, largest(x => 10 * x - x * x, 1 to 10) should return 25. Don’t use a loop or recursion.

  "Exercise 5" should "return largest value of function" in {
    def largest(fun: (Int) => Int, inputs: Seq[Int]): Int = inputs.map(fun).max

    val result = largest(x => 10 * x - x * x, 1 to 10)
    assert(25 == result)
  }

  "Exercise 6" should "return input at which  value of function is largest" in {
    def largest(fun: (Int) => Int, inputs: Seq[Int]): Int = {
      inputs.map(x => (x, fun(x))).sortWith(_._2 > _._2).take(1).head._1
    }

    val result = largest(x => 10 * x - x * x, 1 to 10)
    assert(5 == result)


  }


  "Exercise 8" should "Make a call to corresponds that checks whether the elements in an array of strings have the lengths given in an array of integers." in {

    val array1 = Array("John", "Jim", "Tom")
    val array2 = Array(4, 3, 3)

    array1.corresponds(array2)(_.length == _)


  }


  "Exercise 10" should "implement control abstraction" in {


  }


}
