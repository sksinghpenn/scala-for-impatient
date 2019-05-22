package com.lifotech.scala.impatient.ch05


// Question 6. In the Person class of Section 5.1, “Simple Classes and Parameterless Methods,” on page 49,
// provide a primary constructor that turns negative ages to 0.
class Person(private var age: Int) {

  if (age < 0) age = 0


  def getAge = age

  def setAge(age: Int) = this.age = age
}
