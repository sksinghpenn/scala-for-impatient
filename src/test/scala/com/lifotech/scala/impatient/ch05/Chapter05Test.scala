package com.lifotech.scala.impatient.ch05

import org.scalatest.FunSuite

import org.junit.Assert

class Chapter05Test extends FunSuite {

  test("BankAccountClass") {

    val bankAccount = new BankAccount(1000000.00)
    bankAccount.deposit(500)

    Assert.assertEquals(1000500.00, bankAccount.getBalance, 0.0)
  }

  test("Time class") {
    val time = new Time(9, 50)
    val newTime = new Time(9, 55)

    Assert.assertEquals(true, time.before(newTime))
  }

  test("TimeInMinutes class") {
    val time = new TimeInMinutes(9, 50)
    val newTime = new TimeInMinutes(9, 55)

    Assert.assertEquals(true, time.before(newTime))
  }

  test("Student class") {
    val student = new Student("shashi", 5000)

    Assert.assertEquals("shashi", student.getName)
  }

  test("PersonWithName class") {
    val person = new PersonWithName("Shashi Singh")
    Assert.assertEquals("Shashi", person.firstName)
  }
}
