package com.lifotech.scala.impatient.ch09


// Question 4: Write a Scala program that writes the powers of 2 and their reciprocals to a file, with the exponent ranging from 0 to 20. Line up the columns: 1      1
//2      0.5
//4      0.25


object PowerOf2WithReciprocals {

  def powerOf2WithReciprocals(file: String = "powerOf2WithReciprocals.txt"): Unit = {
    import java.io.{File, FileWriter}


    val reciprocals = for (i <- 1 to 20) yield {
      i + " " + 1 / math.pow(i, 2)
    }

    val fileWriter = new FileWriter(new File(file + "." + math.random().toInt ));

    for (reciprocal <- reciprocals) {
      fileWriter.write(reciprocal + "\n")
    }

    fileWriter.close()
  }

}
