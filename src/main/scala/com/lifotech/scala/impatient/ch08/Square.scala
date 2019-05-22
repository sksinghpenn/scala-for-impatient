package com.lifotech.scala.impatient.ch08

class Square(point: Point, width: Int) extends java.awt.Rectangle {


  val center: Point = point
  val widthOfSquare = width

  def this(width: Int) = {
    this(new Point(0, 0), width)
  }

  def this() {
    this(new Point(0, 0), 0)
  }


}
