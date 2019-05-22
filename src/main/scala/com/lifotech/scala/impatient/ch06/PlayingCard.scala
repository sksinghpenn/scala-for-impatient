package com.lifotech.scala.impatient.ch06

// Question 6. Write an enumeration describing the four playing card suits so that the
// toString method returns ♣, ♦, ♥, or ♠.
object PlayingCard extends Enumeration {


  // U+2660	U+2665	U+2666	U+2663
  //♠	♥	♦	♣
  // Spade, Heart, Diamond,	Club

  type PlayingCard = Value
  val SPADE = Value("\u2660")
  val HEART = Value("\u2665")
  val DIAMOND = Value("\u2666")
  val CLUB = Value("\u2663")


  override def toString = s"PlayingCard(${SPADE}, ${HEART}, ${DIAMOND}, ${CLUB})"
}
