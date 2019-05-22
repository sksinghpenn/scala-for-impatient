package com.lifotech.scala.impatient.ch05

// Question 1: Improve the Counter class in Section 5.1, “Simple Classes and Parameterless Methods,”
// on page 49 so that it doesn’t turn negative at Int.MaxValue.

class BankAccount(private var balance: Double) {


  def deposit(amount: Double): Unit = {
    if (amount > 0.0) balance += amount
  }

  def withdraw(amount: Double): Unit = {
    if (amount >= 0.0 && amount <= balance) balance -= amount
  }

  def getBalance = balance


  override def toString = s"BankAccount($balance)"
}
