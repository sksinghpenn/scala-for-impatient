package com.lifotech.scala.impatient.ch17


// Question 1. Define an immutable class Pair[T, S] with a method swap that returns a new pair with
// the components swapped.


case class Pair[S, T](first: S, second: T) {


  def swap: Pair[T, S] = {
    Pair(second, first)
  }


}

object Pair {
  def swap[S,T](pair: Pair[S,T]) = {
    Pair(pair.second, pair.first)
  }

}

