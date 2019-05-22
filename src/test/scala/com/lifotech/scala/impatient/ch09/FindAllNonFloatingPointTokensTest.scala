package com.lifotech.scala.impatient.ch09

import org.scalatest.{BeforeAndAfter, BeforeAndAfterAll, FlatSpec, FunSuite, Matchers}

class FindAllNonFloatingPointTokensTest extends FunSuite with Matchers with BeforeAndAfter with BeforeAndAfterAll {

  test("all non floating point tokens ") {
    val tokens = FindAllNonFloatingPointTokens.findAllNonFloatingPointTokens("file5.txt")


    assert(Array("this", "is", "my", "life", "and", "and") === tokens)
  }

}
