package com.lifotech.scala.impatient.ch17

case class NewPair[T](var first: T, var second: T) {

  def swap() = {
    val tmp = first
    first = second
    second = tmp
    this
  }

  
}
