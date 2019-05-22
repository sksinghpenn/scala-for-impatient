package com.lifotech.scala.impatient.ch08


/**
  * Question : 3: Consult your favorite Java or C++ textbook that is sure to have an example of a toy
  * inheritance hierarchy, perhaps involving employees, pets, graphical shapes, or the like.
  * Implement the example in Scala.
 */

class Employee( name: String) {
  private val employeeName = name
}

class FullTimeEmployee(name: String, val salary: Double) extends Employee(name)

class ContractorEmployee(name: String, val hourlyRate: Double) extends Employee(name)
