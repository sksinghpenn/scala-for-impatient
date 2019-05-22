package com.lifotech.scala.impatient.ch03

import org.scalatest.FunSuite
import org.junit.Assert

class Chapter03Test extends FunSuite {

  test("swap elements") {
    val arr: Array[Int] = Array(1, 2, 3, 4, 5)
    Chapter03.swap(arr)
    Assert.assertArrayEquals(Array(2, 1, 4, 3, 5), arr)
  }

  test("swap elements using swapUsingForYield") {
    val arr: Array[Int] = Array(1, 2, 3, 4, 5)
    val results:Array[Int] = Chapter03.swapUsingForYield(arr)
    println(results.mkString(","))
    Assert.assertArrayEquals(Array(2, 1, 4, 3, 5), results)
  }
}
