package com.lifotech.scala.impatient.ch05

// Question 4. Reimplement the Time class from the preceding exercise
// so that the internal representation is the number of minutes since midnight
// (between 0 and 24 × 60 – 1). Do not change the public interface.
// That is, client code should be unaffected by your change.


class TimeInMinutes(private var hrs: Int, private var min: Int) {

  require(hrs >= 0 && hrs <= 23, "hrs must be between 0 and 23")
  require(min >= 0 && min <= 59, "min must be between 0 and 23")

  private val time: Long = hrs * 60 + min

  def before(other: TimeInMinutes): Boolean = (this.time < other.time)
}
