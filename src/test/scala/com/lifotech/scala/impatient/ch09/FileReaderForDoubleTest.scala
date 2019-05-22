package com.lifotech.scala.impatient.ch09

import org.scalatest.{BeforeAndAfter, BeforeAndAfterAll, FlatSpec, Matchers}

class FileReaderForDoubleTest extends FlatSpec with Matchers with BeforeAndAfter with BeforeAndAfterAll{

  "sum of the double" should  "207.46" in {
    val sum = FileReaderForDouble.sum("file4.txt")
    assert(sum == 207.46)
  }

  "avg of the double" should  "207.46" in {
    val avg = FileReaderForDouble.avg("file4.txt")
    assert(avg == 34.57666666666667)
  }

  "max of the double" should  "207.46" in {
    val max = FileReaderForDouble.max("file4.txt")
    assert(max == 50.45)
  }

  "min of the double" should  "207.46" in {
    val min = FileReaderForDouble.min("file4.txt")
    assert(min == 2.03)
  }
}
