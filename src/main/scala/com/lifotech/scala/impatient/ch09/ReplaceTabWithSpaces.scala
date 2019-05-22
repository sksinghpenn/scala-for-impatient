package com.lifotech.scala.impatient.ch09

object ReplaceTabWithSpaces {

  private def getResource(r: String): String = com.google.common.io.Resources.getResource(r).getPath


  def replaceTabsWithSpaces(file: String): Unit = {
    import java.io.{File, FileWriter, PrintWriter}

    val fileContent = scala.io.Source.fromFile(file).mkString


    val fileContentTabReplaced = fileContent.replaceAll("l","s")

    val fileWriter = new FileWriter(new File(file))

    fileWriter.write(fileContentTabReplaced)

    fileWriter.close()


  }

}
