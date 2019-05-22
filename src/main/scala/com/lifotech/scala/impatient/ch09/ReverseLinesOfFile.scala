package com.lifotech.scala.impatient.ch09

/*
Question 1: Write a Scala code snippet that reverses the lines in a file
(making the last line the first one, and so on).
 */

object FileUtil {

  import scala.collection.mutable.ArrayBuffer

  private def getResource(r: String): String = com.google.common.io.Resources.getResource(r).getPath

  def reverseLines(file: String): Vector[String] = {
    val lines = scala.io.Source.fromFile(getResource(file)).getLines().toList
    processLines(lines).toVector
  }

  private def processLines(allLines: List[String]): ArrayBuffer[String] = {
    def processLinesAcc(linesBeforeLast: List[String], acc: scala.collection.mutable.ArrayBuffer[String]): ArrayBuffer[String] = {

      if (linesBeforeLast.isEmpty) acc
      else processLinesAcc(linesBeforeLast.init, acc += linesBeforeLast.last)


    }

    processLinesAcc(allLines.init, scala.collection.mutable.ArrayBuffer(allLines.last))
  }


}
