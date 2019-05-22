package com.lifotech.scala.impatient.ch13

import org.scalatest.{BeforeAndAfter, BeforeAndAfterAll, FlatSpec, Matchers}

class Class13 extends FlatSpec with Matchers with BeforeAndAfter with BeforeAndAfterAll {

  "Exercise 1" should "produces a map of the indexes of all characters using zipWithIndex." in {


    def indexes(str: String) = {
      val strZippedWithIndex = str.zipWithIndex

      strZippedWithIndex.groupBy(_._1).mapValues(_.map(_._2).toSet)

    }

    val result = indexes("Mississippi")

    val expectedResult = Map('M' -> Set(0), 's' -> Set(2, 3, 5, 6), 'p' -> Set(8, 9), 'i' -> Set(1, 4, 7, 10))

    assert(expectedResult === result)

  }

  "Exercise 1" should "produces a map of the indexes of all characters using a mutable map of characters to mutable sets." in {


    def indexes(str: String) = {

      import scala.collection.mutable

      val initMap: mutable.Map[Char, mutable.Set[Int]] = mutable.Map.empty[Char, mutable.Set[Int]]

      for (i <- 0 until str.length) {
        initMap += (str(i) -> (initMap.get(str(i)).getOrElse(mutable.Set()) + i))
      }

      initMap
    }

    val result = indexes("Mississippi")

    val expectedResult = Map('M' -> Set(0), 's' -> Set(2, 3, 5, 6), 'p' -> Set(8, 9), 'i' -> Set(1, 4, 7, 10))

    assert(expectedResult === result)

  }

  "Exercise 2" should "produces a immutable map of  characters to list" in {
    def indexes(str: String) = {
      var initMap: Map[Char, List[Int]] = Map.empty[Char, List[Int]]

      for (i <- 0 until str.length) {
        initMap += (str(i) -> (initMap.get(str(i)).getOrElse(List()) :+ i))
      }

      initMap
    }

    val result = indexes("Mississippi")

    val expectedResult = Map('M' -> List(0), 'i' -> List(1, 4, 7, 10), 's' -> List(2, 3, 5, 6), 'p' -> List(8, 9))

    assert(expectedResult === result)

  }


  "Exercise 3" should "remove all zeros from a linked list of integers" in {

    def removeZeros(list: Seq[Int]): Seq[Int] = list.map(_.toString.filterNot(_ == '0').toInt)

    val result = removeZeros(List(100, 200, 305))

    val expectedResult = removeZeros(List(1, 2, 35))

    assert(expectedResult === result)
  }

  "Exercise 4" should "integers. Return a collection of integers that are values of the map corresponding to one of the strings in the collection" in {

    def matchArrayElementWithMapValues(strings: Array[String], mapOfString: Map[String, Int]): Array[Int] = {
      strings.map(str => mapOfString.filter(_._1 == str)).flatMap(_.map(_._2))
    }

    val array = Array("Tom", "Fred", "Harry")
    val map = Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)

    val result = matchArrayElementWithMapValues(array, map)

    val expectedResult = Array(3, 5)

    assert(expectedResult === result)

  }

  "Exercise 5" should "implement function works just like mkString, using reduceLeft" in {

    def mkStringLike(prefix: String, str: Array[String], sep: String, suffix: String): String = prefix + str.reduceLeft(_ + sep + _) + suffix

    val result = mkStringLike("Mr.", Array("John", "Doe", "Singh"), ",", "")

    assert(result == "Mr.John,Doe,Singh")

  }

  /*6. Given a list of integers lst, what is (lst :\ List[Int]())(_ :: _)?
    (List[Int]() /: lst)(_ :+ _)? How can you modify one of them to reverse the list?
*/
  "Exercise 6" should "copy the element of the list into another using foldRight" in {
    val lst = List(1, 2, 3, 4)

    val newList = (lst :\ List[Int]()) (_ :: _)

    assert(List(1, 2, 3, 4) === newList)

    // this  is equivalent to the rightFold

    val newListUsingFoldRight = lst.foldRight(List[Int]())(_ :: _)
    assert(List(1, 2, 3, 4) === newListUsingFoldRight)
  }

  "Exercise 6" should "copy the element of the list into another using foldLeft" in {
    val lst = List(1, 2, 3, 4)

    val newList = (List[Int]() /: lst) (_ :+ _)

    assert(List(1, 2, 3, 4) === newList)

    // this  is equivalent to the rightFold

    val newListUsingFoldLeft = lst.foldLeft(List[Int]())(_ :+ _)
    assert(List(1, 2, 3, 4) === newListUsingFoldLeft)
  }

  "Exercise 6" should "copy the element of the list into another using foldLeft in reverse order" in {
    val list = List(1, 2, 3, 4)

    val newReverseListUsingFoldLeft = list.reverse.foldLeft(List[Int]())(_ :+ _)
    assert(List(4, 3, 2, 1) === newReverseListUsingFoldLeft)
  }

  /* Question 7. In Section 13.11, “Zipping,” on page 171, the expression (prices zip quantities)
  map { p => p._1 * p._2 } is a bit inelegant. We can’t do (prices zip quantities) map { _ * _ }
  because _ * _ is a function with two arguments, and we need a function with one
  argument that is a tuple. The tupled method of the Function2 object changes a function
  with two arguments to one that takes a tuple. Apply tupled to the multiplication function
  so you can map it over the list of pairs.*/

  "Execise 7" should "use Function.tupled to calculate total price" in {


    val prices: List[Double] = List(5.0, 20.0, 9.95)
    val quantities: List[Int] = List(10, 2, 1)

    // def f:(x:Int, y:Int):Int => x * y
    // convert method in functon
    // val ff = f _
    // call Function.tupled(ff)
    // will return ((Int,Int)) => Int

    val totalPrice = prices zip quantities map Function.tupled(_ * _)

    // above each tuple from the list of map is passed to the output of Function.tupled( _ * _) , which is  ((Int,Int)) => Int


    assert(List(50.0, 40.0, 9.95) == totalPrice)
  }

  //8. Write a function that turns an array of Double values into a two-dimensional array.
  //Pass the number of columns as a parameter. For example, with Array(1, 2, 3, 4, 5, 6)
  //and three columns, return Array(Array(1, 2, 3), Array(4, 5, 6)). Use the grouped method.

  "Exercise 8" should "array of double into into two dimensional array " in {

    def convertIntoTwoDim(arr: Seq[Int], columns: Int): List[Seq[Int]] = arr.grouped(columns).toList

    val arr = Array(1, 2, 3, 4, 5, 6)

    val result = convertIntoTwoDim(arr, 3)

    assert(result === List(Seq(1, 2, 3), Seq(4, 5, 6)))
  }


  // Question 9. Harry Hacker writes a program that accepts a sequence of file names on the command line.
  // For each, he starts a new thread that reads the file and updates a letter frequency map,
  // declared as val frequencies = new scala.collection.mutable.HashMap[Char, Int] with
  // scala.collection.mutable.SynchronizedMap[Char, Int] When reading a letter c, he calls
  // frequencies(c) = frequencies.getOrElse(c, 0) + 1 Why won’t this work? Will it work if he used instead
  // import scala.collection.JavaConversions.asScalaConcurrentMap
  // val frequencies: scala.collection.mutable.ConcurrentMap[Char, Int] = new java.util.concurrent.ConcurrentHashMap[Char, Int]

  "Exercise 9" should "test java to scala conversion how it works" in {


    def findWordFrequencies(files: Array[String]): Map[Char, Int] = {

      import scala.collection.JavaConversions.mapAsScalaConcurrentMap

      val frequencies: scala.collection.mutable.Map[Char, Int] = new java.util.concurrent.ConcurrentHashMap[Char, Int]

      for (file <- files) {
        val thread: Thread = new Thread {
          override def run() = {
            val allChars = scala.io.Source.fromResource(file)

            val charMap = allChars.map((_, 1))

            val onlyCharMap = charMap.filterNot(x => x._1.toString.trim == "")

            onlyCharMap.foreach { ch => frequencies += (ch._1 -> (frequencies.getOrElse(ch._1, 0) + 1)) }
          }
        }
      }

      frequencies.toMap

    }


  }


}