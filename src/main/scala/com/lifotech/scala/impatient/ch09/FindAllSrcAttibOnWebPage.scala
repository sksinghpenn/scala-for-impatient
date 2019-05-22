package com.lifotech.scala.impatient.ch09

object FindAllSrcAttibOnWebPage {

  def findAllSrcAttribOnWebPage(url: String): Array[String] = {
    import java.net.URL

    val lines = scala.io.Source.fromURL(url, "ISO-8859-1").getLines().toList

    val pattern = "<[iI][Mm][Gg].+>".r

    val wordsWithImgTag = lines.map(line => pattern.findAllIn(line)).flatten
    wordsWithImgTag.foreach(println)

    val wordsInImagTag = wordsWithImgTag.flatMap(word => word.split(" "))


    wordsInImagTag.filter(word => word.startsWith("src")).toArray


  }


}
