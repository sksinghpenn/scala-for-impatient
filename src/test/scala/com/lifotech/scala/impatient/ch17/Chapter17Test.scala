package com.lifotech.scala.impatient.ch17

import org.scalatest.{BeforeAndAfter, BeforeAndAfterAll, FlatSpec, Matchers}


class Chapter17Test extends FlatSpec with Matchers with BeforeAndAfter with BeforeAndAfterAll {

  //Question 1: 1. Define an immutable class Pair[T, S] with a method swap that
  // returns a new pair with the components swapped.

  "Exercise 1" should "swap pair elements by creating new one" in {
    val pair = Pair("A", 10)

    val result = pair.swap

    assert(Pair(10, "A") === result)

  }

  "Exercise 2" should "swap pair elements by mutating" in {
    val pair = NewPair("A", "B")

    val result = pair.swap

    assert(NewPair("B", "A") === result)

  }


  "Exercise 3" should "swap pair elements " in {
    val result = Pair.swap(Pair("A", 10))
    assert(Pair(10, "A") === result)

  }

  //4. Why don’t we need a lower bound for the replaceFirst method in Section 17.3,
  // “Bounds for Type Variables,” on page 232 if we want to replace the first component
  // of a Pair[Person] Person] with a Student?


  // Question 6. Write a generic method middle that returns the middle element from any Iterable[T].
  // For example, middle("World") is 'r'.

  def middle[T](element: Iterable[T]): T = {
    val length: Int = element.size
    val mid = length / 2 + length % 2
    element.toList(mid-1)
  }

  "Exercise 6" should "find middle element from the string " in {
    val result = middle("World")
    assert('r' === result)
  }

  "Exercise 6" should "find middle element from the list " in {
    val result = middle(List("jhon", "jack", "tom"))
    assert("jack" === result)
  }
}

