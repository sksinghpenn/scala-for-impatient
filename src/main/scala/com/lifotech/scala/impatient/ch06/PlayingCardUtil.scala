package com.lifotech.scala.impatient.ch06


// Question 7. Implement a function that checks whether a card suit value from the preceding exercise is red.
object PlayingCardUtil {

  import com.lifotech.scala.impatient.ch06.PlayingCard.PlayingCard

  def isCardRed(playingCard: PlayingCard) = {
    (playingCard == PlayingCard.HEART) || (playingCard == PlayingCard.DIAMOND)
  }

}
