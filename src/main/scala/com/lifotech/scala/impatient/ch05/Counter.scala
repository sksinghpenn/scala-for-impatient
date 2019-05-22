package com.lifotech.scala.impatient.ch05

class Counter {

  private var value = 0

  def increment(): Unit = {
    if (value == Int.MaxValue) value = 0
    else value += 1
  }

  def current() = value

}
