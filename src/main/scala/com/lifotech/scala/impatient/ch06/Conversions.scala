package com.lifotech.scala.impatient.ch06


// Question 1: Write an object Conversions with methods inchesToCentimeters,
// gallonsToLiters, and milesToKilometers.

object Conversions {

  def inchesToCentimeters(inch: Double): Double = 2.54 * inch

  def gallonsToLiters(gallons: Double): Double = 3.78541 * gallons

  def milesToKilometers(miles: Double): Double = 1.60934 * miles

}
