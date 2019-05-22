package com.lifotech.scala.impatient.ch09


// Question 3: Write a Scala code snippet that reads a file and prints all words
// with more than 5 characters to the console. Extra credit if you can do this in a single line.


object FileReaderForWord {

  def wordsFromFile(file: String): Array[String] = scala.io.Source.fromResource(file).getLines().mkString.split(" ").filter(_.length >= 8)


}
