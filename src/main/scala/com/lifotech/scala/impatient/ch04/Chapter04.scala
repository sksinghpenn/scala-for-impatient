package com.lifotech.scala.impatient.ch04

object Chapter04 {

  // Question 1: Set up a map of prices for a number of gizmos that you covet.
  // Then produce a second map with the same keys and the prices at a 10 percent discount.
  def getGizomsDiscountedPrice(gizomsPriceMap: Map[String, Double]): Map[String, Double] = {
    for ((itemName, price) <- gizomsPriceMap) yield (itemName, price - (price * 0.10))
  }


  // Question 2. Write a program that reads words from a file. Use a mutable map
  // to count how often each word appears.
  // To read the words, simply use a java.util.Scanner: Click here to view code
  // image val in = new java.util.Scanner(new java.io.File("myfile.txt"))

  def wordCount(fileName: String): Map[String, Int] = {
    val lines = scala.io.Source.fromFile(fileName).getLines()

    val map = scala.collection.mutable.Map.empty[String, Int]

    while (lines.hasNext) {
      val words = lines.next().split(" ")
      for (word <- words if word.length > 0) {
        if (map.get(word).isEmpty) {
          map.put(word, 1)
        } else {
          map.update(word, map.get(word).get + 1)
        }
      }

    }

    map.toMap

  }


  // Question 3. Repeat the preceding exercise with an immutable map.
  def wordCountImmuatableMap(fileName: String): Map[String, Int] = {
    val lines = scala.io.Source.fromFile(fileName).getLines()

    var map = scala.collection.immutable.Map.empty[String, Int]

    while (lines.hasNext) {
      val words = lines.next().split(" ")
      for (word <- words if word.length > 0) {
        if (map.get(word).isEmpty) {
          map += (word -> 1)
        } else {
          map += (word -> (map.get(word).get + 1))
        }
      }

    }

    map

  }

  // Question 4. Repeat the preceding exercise with a sorted map, so that the words are printed in sorted order.
  def wordCountSortedMap(fileName: String): Map[String, Int] = {
    val lines = scala.io.Source.fromFile(fileName).getLines()

    var sortedMap = scala.collection.immutable.SortedMap.empty[String, Int]


    while (lines.hasNext) {
      val line = lines.next()

      val words = line.split(" ")

      for (word <- words if word.length > 0) {
        if (sortedMap.get(word).isEmpty) {
          sortedMap += (word -> 1)

        } else {
          sortedMap += (word -> (sortedMap.get(word).get + 1))
        }
      }
    }

    sortedMap
  }

  // Question 5. Repeat the preceding exercise with a java.util.TreeMap that you adapt to the Scala API.
  def wordCountJavaTreeMap(fileName: String): Map[String, Int] = {

    val lines = scala.io.Source.fromFile(fileName).getLines()

    import scala.collection.JavaConversions.mapAsScalaMap


    var map: scala.collection.mutable.Map[String, Int] = new java.util.TreeMap[String, Int]()

    while (lines.hasNext) {
      val words = lines.next().split(" ")
      for (word <- words if word.length > 0) {
        if (map.get(word).isEmpty) {
          map += (word -> 1)
        } else {
          map += (word -> (map.get(word).get + 1))
        }
      }

    }

    map.toMap
  }


  def wordCountNonExerciseButFunctionalSolution(fileName: String): Map[String, Int] = {
    val lines = scala.io.Source.fromFile(fileName).getLines().toList

    val wordsList = lines.flatMap(line => line.trim.split(" "))

    val wordCountMap = wordsList.filter(word => word.length > 0).map(word => (word, 1))

    wordCountMap.groupBy(_._1).mapValues(wordCount => wordCount.map(_._2).sum)
  }

  // Question 6:Define a linked hash map that maps "Monday" to java.util.Calendar.MONDAY,
  // and similarly for the other weekdays. Demonstrate that the elements are visited in insertion order.
  def calendarWeekDays(): scala.collection.mutable.LinkedHashMap[String, Int] = {
    val calendarDays = scala.collection.mutable.LinkedHashMap.empty[String, Int]

    calendarDays += ("Monday" -> java.util.Calendar.MONDAY)
    calendarDays += ("Sunday" -> java.util.Calendar.SUNDAY)
    calendarDays += ("Tuesday" -> java.util.Calendar.TUESDAY)
    calendarDays += ("Wednesday" -> java.util.Calendar.WEDNESDAY)
    calendarDays += ("Thursday" -> java.util.Calendar.THURSDAY)
    calendarDays += ("Friday" -> java.util.Calendar.FRIDAY)
    calendarDays += ("Saturday" -> java.util.Calendar.SATURDAY)

    calendarDays

  }

  //  Question 7: Print a table of all Java properties:
  // java.runtime.name             | Java(TM) SE Runtime Environment
  //  sun.boot.library.path        | /home/apps/jdk1.6.0_21/jre/lib/i386
  //  java.vm.version              | 17.0-b16
  //  java.vm.vendor               | Sun Microsystems Inc.
  //  java.vendor.url              | http://java.sun.com/
  //  path.separator               | :
  //  java.vm.name                 | Java HotSpot(TM) Server VM You need to find the length of the longest key before you can print the table.

  def printSystemProperties() = {
    import scala.collection.JavaConversions.propertiesAsScalaMap
    val propsMap:scala.collection.Map[String, String] = System.getProperties()
    
    for((k,v) <- propsMap) {
      println(s"$k | $v")
    }
  }

}
