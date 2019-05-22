package com.lifotech.scala.impatient.ch04

import org.scalatest.FunSuite
import org.junit.Assert

class Chapter04Test extends FunSuite {

  test("test getGizomsDiscountedPrice") {
    val priceMap: Map[String, Double] = Map("TShirt" -> 100.00, "Shoe" -> 10.00, "Tie" -> 30.00)
    val expectedPriceMap = Map("TShirt" -> 90.00, "Shoe" -> 9.00, "Tie" -> 27.00)
    Assert.assertEquals(expectedPriceMap, Chapter04.getGizomsDiscountedPrice(priceMap))

  }

 
}
