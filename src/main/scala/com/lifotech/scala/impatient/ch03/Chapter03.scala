package com.lifotech.scala.impatient.ch03

import scala.reflect.ClassTag
import java.util.TimeZone

object Chapter03 {

  import scala.reflect.ClassTag


  // Question 1. Write a code snippet that sets a to an array of n random integers
  // between 0 (inclusive) and n (exclusive).

  def initArray(n: Int): Array[Int] = {

    val arr: Array[Int] = Array[Int](n)

    for (i <- 0 until n) {
      arr(i) = scala.util.Random.nextInt(n)
    }

    arr

  }

  // Question 2. Write a loop that swaps adjacent elements of an array of integers.
  // For example, Array(1, 2, 3, 4, 5) becomes Array(2, 1, 4, 3, 5).
  def swap(arr: Array[Int]) = {
    for (i <- 0 until arr.length - 1 by 2) {
      val temp = arr(i)
      arr(i) = arr(i + 1)
      arr(i + 1) = temp
    }
  }

  // Question 3. Repeat the preceding assignment, but produce a new array with the swapped values.
  // Use for/yield.
  def swapUsingForYield(arr: Array[Int]): Array[Int] = {
    val newArray = new Array[Int](arr.length)
    for (i <- 0 until arr.length) yield {
      if (i % 2 == 0) {
        if (i < arr.length - 1) newArray(i) = arr(i + 1)
        else newArray(i) = arr(i)
      }
      else newArray(i) = arr(i - 1)
    }

    newArray.toArray
  }


  // Question  5. How do you compute the average of an Array[Double]?
  def average(arr: Array[Double]) = arr.sum / arr.length


  // Question 6. How do you rearrange the elements of an Array[Int]
  // so that they appear in reverse sorted order?
  // How do you do the same with an ArrayBuffer[Int]?
  def sort(array: Array[Int]): Array[Int] = array.sortWith(_ > _)


  // Question 7. Write a code snippet that produces all values from an array with duplicates removed. (Hint: Look at Scaladoc.)
  def deDuplicate[T: ClassTag](array: Array[T]): Array[T] = {
    import scala.collection.mutable.ArrayBuffer

    val buffer: ArrayBuffer[T] = ArrayBuffer.empty

    for (elem <- array) {
      if (!buffer.contains(elem)) buffer.append(elem)
    }
    buffer.toArray
  }

  // Question 9: 9. Make a collection of all time zones returned by java.util.TimeZone.getAvailableIDs that are in America.
  // Strip off the "America/" prefix and sort the result.

  def timeZone(): Array[String] = TimeZone.getAvailableIDs.filter(_.startsWith("America/")).map(_.stripPrefix("America/")).sorted


}


