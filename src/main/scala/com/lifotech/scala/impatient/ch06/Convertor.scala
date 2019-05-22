package com.lifotech.scala.impatient.ch06


// Question 2. The preceding problem wasn’t very object-oriented. Provide a general superclass UnitConversion
// and define objects InchesToCentimeters, GallonsToLiters, and MilesToKilometers that extend it.
object Convertor extends UnitConversion {
  override def inchesToCentimeters(inch: Double): Double = 2.54 * inch

  override def gallonsToLiters(gallons: Double): Double = 3.78541 * gallons

  override def milesToKilometers(miles: Double): Double = 1.60934 * miles
}

