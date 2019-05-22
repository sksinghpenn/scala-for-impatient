package com.lifotech.scala.impatient.ch01

import org.scalatest.FunSuite
import org.junit.Assert

class TestCh01 extends FunSuite {

  test("compute 2 to 1024 using package Object") {

    val result = computePow(2, 8)

    Assert.assertEquals(BigInt(256), result)
  }


  test("compute 2 to 1024 using singleton object") {

    val result = Chapter01.compute(2, 8)

    Assert.assertEquals(BigInt(256), result)
  }

}
