package com.lifotech.scala.impatient.ch02

import org.scalatest.FunSuite
import org.junit.Assert

class TestChapter02 extends FunSuite {

  test("signnum of 5 should be 1") {
    Assert.assertEquals(1, Chapter02.sigNum(5))
  }

}
