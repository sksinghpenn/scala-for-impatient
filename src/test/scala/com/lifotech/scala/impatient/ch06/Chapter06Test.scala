package com.lifotech.scala.impatient.ch06

import org.scalatest.FunSuite


import junit.framework.Assert

class Chapter06Test extends FunSuite {

  test("test Convertor") {
    Assert.assertEquals(25.4, Convertor.inchesToCentimeters(10))
  }

  test("test Point Companion") {
    val point: Point = Point(3, 4)
    Assert.assertEquals(Point(3, 4), point)
  }


  test("test PlayingCard") {

    println(PlayingCard.toString)

  }


  test("test PlayingCard by displaying each card type") {
    import com.lifotech.scala.impatient.ch06.PlayingCard.PlayingCard


    def testEnumeration(playingCard: PlayingCard) = {
      println(playingCard)
    }

    testEnumeration(PlayingCard.SPADE)
    testEnumeration(PlayingCard.CLUB)
    testEnumeration(PlayingCard.DIAMOND)
    testEnumeration(PlayingCard.HEART)
  }

  test("is playing card RED") {
    PlayingCardUtil.isCardRed(PlayingCard.withName("\u2660"))
  }
}
