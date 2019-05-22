package com.lifotech.scala.impatient.ch08


/**
  * Question 1. Extend the following BankAccount class to a CheckingAccount class
  * that charges $1 for every deposit and withdrawal.
  */
class BankAccount(initialBalance: Double) {

  private var balance = initialBalance

  def currentBalance = balance

  def deposit(amount: Double) = {
    balance += amount
    balance
  }

  def withdraw(amount: Double) = {
    balance -= amount
    balance
  }


}

class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {

  override def deposit(amount: Double) = {
    super.deposit(amount + 1.00)

  }

  override def withdraw(amount: Double) = {
    super.deposit(amount - 1.00)
  }
}


class SavingsAccount(initialBalance: Double) extends BankAccount(initialBalance) {

  override def deposit(amount: Double) = {
    super.deposit(amount + 1.00)

  }

  override def withdraw(amount: Double) = {
    super.deposit(amount - 1.00)
  }

  def earnMonthlyInterest() = {
    
  }
}
