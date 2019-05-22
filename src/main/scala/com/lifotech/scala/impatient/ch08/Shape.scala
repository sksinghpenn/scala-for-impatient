package com.lifotech.scala.impatient.ch08

abstract class Shape {

  def centerPoint: Point

}


class Rectangle(val point: Point) extends Shape {
  override def centerPoint: Point = point
}

class Circle(val point: Point) extends Shape {
  override def centerPoint: Point = point
}