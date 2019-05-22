package com.lifotech.scala.impatient.ch09

import org.scalatest._

class ReverseLinesOfFileTest extends FlatSpec with Matchers with BeforeAndAfter with BeforeAndAfterAll {

  "it" should "reverse file lines are reversed" in {

    val lines = FileUtil.reverseLines("file0.txt")

    lines.foreach(println)
  }
}
