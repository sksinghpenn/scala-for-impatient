package com.lifotech.scala.impatient.ch05

// Question 10:
// Consider the class
// class Employee(val name: String, var salary: Double) {
//  def this() { this("John Q. Public", 0.0) }
//}

// Rewrite it to use explicit fields and a default primary constructor. Which form do you prefer? Why?


class Employee {

  private var name: String = ""
  private var salary: Double = 0.0

  def this(name: String, salary: Double) {
    this()
    this.name = name
    this.salary = salary
  }


  def getName = this.name

  def getSalary = this.salary

  def setSalary(salary: Double): Unit = {
    this.salary = salary
  }


}
