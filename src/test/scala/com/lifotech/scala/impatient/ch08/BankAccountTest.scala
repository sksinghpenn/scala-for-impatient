package com.lifotech.scala.impatient.ch08

import org.scalatest.{BeforeAndAfter, BeforeAndAfterAll, FlatSpec, Matchers}

class BankAccountTest extends FlatSpec with Matchers with BeforeAndAfter with BeforeAndAfterAll {


  override def beforeAll(): Unit = {

  }

  override def afterAll(): Unit = {

  }


  "deposit $10.00 in checking account" should "show $11.00 as balance" in {
    val checkingAccount = new CheckingAccount(0)

    checkingAccount.deposit(10.00)

    assert(11.00 == checkingAccount.currentBalance)
  }


}