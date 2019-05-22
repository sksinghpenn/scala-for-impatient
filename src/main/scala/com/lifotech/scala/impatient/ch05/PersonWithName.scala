package com.lifotech.scala.impatient.ch05


// Question 7. Write a class Person with a primary constructor that accepts a string containing a first name,
// a space, and a last name, such as new Person("Fred Smith"). Supply read-only properties firstName and lastName.
// Should the primary constructor parameter be a var, a val, or a plain parameter? Why?


class PersonWithName(private[this] val name: String) {

  val firstName: String = name.split(" ")(0).trim
  val lastName: String = name.split(" ")(1).trim


}
