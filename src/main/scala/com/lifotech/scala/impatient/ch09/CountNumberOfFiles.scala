package com.lifotech.scala.impatient.ch09


// Question 9. Write a Scala program that counts how many files
// with .class extension are in a given directory and its subdirectories.
object CountNumberOfFiles {

  def countNumberOfFiles(file: String): String = {
    import scala.sys.process._

    val str = "ls -R -l " + file

    str.toString #| "grep .class" #| "wc -l" !!

  }

}

