package com.lifotech.scala.impatient.ch06

class Point(val x: Int, val y: Int) {


  def canEqual(other: Any): Boolean = other.isInstanceOf[Point]

  override def equals(other: Any): Boolean = other match {
    case that: Point =>
      (that canEqual this) &&
        x == that.x &&
        y == that.y
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(x, y)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }


  override def toString = s"Point($x, $y)"
}

object Point {
  def apply(x: Int, y: Int): Point = new Point(x, y)
}
