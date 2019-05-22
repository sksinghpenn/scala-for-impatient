package com.lifotech.scala.impatient.ch09

object FileReaderForDouble {

  def sum(file: String):Double = {
    val lines = scala.io.Source.fromResource(file).getLines().toList

    val words = lines.flatMap(line => line.split(" "))

    words.map(_.toDouble).sum
  }

  def avg(file: String):Double = {
    val lines = scala.io.Source.fromResource(file).getLines().toList

    val words = lines.flatMap(line => line.split(" "))

    words.map(_.toDouble).sum / words.size
  }

  def max(file: String):Double = {
    val lines = scala.io.Source.fromResource(file).getLines().toList

    val words = lines.flatMap(line => line.split(" "))

    words.map(_.toDouble).max
  }

  def min(file: String):Double = {
    val lines = scala.io.Source.fromResource(file).getLines().toList

    val words = lines.flatMap(line => line.split(" "))

    words.map(_.toDouble).min
  }
}
