package com.lifotech.scala.impatient.ch09

object FindAllNonFloatingPointTokens {

  def findAllNonFloatingPointTokens(file: String): Array[String] = {

    val lines = scala.io.Source.fromResource(file).mkString

    val wordPattern  = "[a-zA-Z]+".r

    wordPattern.findAllIn(lines) .toArray
  }
}
