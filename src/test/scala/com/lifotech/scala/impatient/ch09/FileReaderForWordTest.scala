package com.lifotech.scala.impatient.ch09

import org.scalatest._


class FileReaderForWordTest extends FlatSpec with Matchers with BeforeAndAfter with BeforeAndAfterAll {


  "test of  FileReaderForWord" should "return 3 words" in {

    val words = FileReaderForWord.wordsFromFile("file3.txt")

    // for Array equality comparision use ===
    assert(Array("pleasure") === (words))
  }

}
