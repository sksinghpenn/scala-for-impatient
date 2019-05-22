package com.lifotech.scala.impatient.ch14

object JDKSourceCodeProcessor {


  def findAllJavaFiles(srcLocation: String): Seq[String] = {
    import java.io.File
    import java.net.URL

    val url: URL = this.getClass.getResource(srcLocation)

    val files = new File(url.toURI)

    files.list().foreach(println)

    val dirs = files.list.filter(new File(_).isDirectory)

    dirs.foreach(println)

    files.list() ++ dirs.flatMap(findAllJavaFiles)

  }
}
