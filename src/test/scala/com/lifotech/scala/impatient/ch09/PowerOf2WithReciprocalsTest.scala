package com.lifotech.scala.impatient.ch09

import org.scalatest.{BeforeAndAfter, BeforeAndAfterAll, FlatSpec, Matchers}

class PowerOf2WithReciprocalsTest extends FlatSpec with Matchers with BeforeAndAfter with BeforeAndAfterAll {


  "powerOf2WithReciprocals test " should "write to file " in {
    PowerOf2WithReciprocals.powerOf2WithReciprocals()
  }
}
