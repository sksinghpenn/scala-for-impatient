package com.lifotech.scala.impatient.ch09

import org.scalatest.{BeforeAndAfter, BeforeAndAfterAll, FlatSpec, Matchers}

class ReplaceTabWithSpacesTest extends FlatSpec with Matchers with BeforeAndAfter with BeforeAndAfterAll {

  "tab in lines" should "be replaced with nospace" in {
       ReplaceTabWithSpaces.replaceTabsWithSpaces("/Users/sksingh/projects/scala/scalaForImpatientBook/src/test/resources/file1.txt")
  }
}
