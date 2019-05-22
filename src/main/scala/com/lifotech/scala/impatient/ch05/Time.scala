package com.lifotech.scala.impatient.ch05


// Question 3. Write a class Time with read-only properties hours and minutes and a method before(other: Time): Boolean
// that checks whether this time comes before the other. A Time object should be constructed as new Time(hrs, min),
// where hrs is in military time format (between 0 and 23).

class Time(private var hrs: Int, private var min: Int) {

  require(hrs >= 0 && hrs <= 23, "hrs must be between 0 and 23")
  require(min >= 0 && min <= 59, "min must be between 0 and 23")

  def before(other: Time): Boolean = (this.hrs < other.hrs) || (this.hrs == other.hrs && this.min < other.min)


}
