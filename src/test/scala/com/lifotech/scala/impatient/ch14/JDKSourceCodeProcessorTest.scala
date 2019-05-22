package com.lifotech.scala.impatient.ch14

import org.scalatest.{BeforeAndAfter, BeforeAndAfterAll, FlatSpec, FunSpec, Matchers}

class JDKSourceCodeProcessorTest extends FlatSpec with Matchers with BeforeAndAfter with BeforeAndAfterAll {


  "Exercise1 " should "test findAllJavaFiles for number of files" in {
    assert(true)
  }


  //Question 2: Using pattern matching, write a function swap that receives a pair of integers
  // and returns the pair with the components swapped.

  def swapPair(a: (Int, Int)): (Int, Int) = a match {
    case (x, y) => (y, x)
    case _ => throw new RuntimeException("Input is not a pair")
  }


  "Exercise 2" should "pair should be swapped " in {
    val result = swapPair((3, 4))
    assert(result === (4, 3))
  }

  //3. Using pattern matching, write a function swap that swaps the first two
  // elements of an array provided its length is at least two.

  def swapArray[T](seq: Seq[T]): Seq[T] = seq match {
    case Seq(x, y, rest@_*) if seq.length > 2 => Seq[T](y, x) ++ rest
    case _ => seq
  }


  "Exercise 3" should "swap when the array contains atleast two elements " in {
    val result = swapArray(Array(2, 3, 5, 6, 7))
    assert(result === List(3, 2, 5, 6, 7))
  }

  "Exercise 3" should "do not swap when the array does not contain atleast two elements " in {
    val result = swapArray(Array(2, 3))
    assert(List(2, 3) === result)
  }

  // Question 4: Add a case class Multiple that is a subclass of the Item class.
  // For example, Multiple(10, Article("Blackwell Toaster", 29.95)) describes ten toasters.
  // Of course, you should be able to handle any items, such as bundles or multiples,
  // in the second argument. Extend the price function to handle this  new case

  sealed abstract class Item extends Serializable

  case class Article(val description: String, price: Double) extends Item


  case class Multiple(howMany: Int, item: Item) extends Item

  case class Bundle(description: String, discount: Double, items: Item*) extends Item


  // Question 5. One can use lists to model trees that store values only in the leaves.
  // For example, the list ((3 8) 2 (5)) describes the tree •
  // /|\
  // • 2 •
  // / \  |
  //3  8  5 However, some of the list elements are numbers and others are lists. In Scala, you cannot have heterogeneous lists,
  // so you have to use a List[Any]. Write a leafSum function to compute the sum of all elements
  // in the leaves, using pattern matching to differentiate between numbers and lists.

  def leafSum(seq: Seq[Any]): Int = seq match {
    case Seq(x: List[Any], rest@_*) => leafSum(x) + leafSum(rest.toList)
    case Seq(x: Int, rest@_*) => x + leafSum(rest.toList)
    case _ => 0
  }


  "Exercise 5" should "find sum of list containing the list in the form of ((3 8) 2 (5)) " in {
    val result = leafSum(List(List(3, 8), 5, List(5)))
    assert(result === 21)
  }

  
  

}
