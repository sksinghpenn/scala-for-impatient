package com.lifotech.scala.impatient.ch08

abstract class Item {

  def price: Double

  def description: String


}


class SampleItem(val price: Double, val description: String) extends Item


class Bundle(bundleItems: Vector[Item]) {

  import scala.collection.mutable.ArrayBuffer

  private var items: ArrayBuffer[Item] = ArrayBuffer(bundleItems: _*)

  val price: Double = {
    items.map(item => item.price).sum
  }

  def addItem(newItem: Item): Unit = {
    items += newItem
  }

  def description: String = {
    "items in the bundle: \n" + items.map(item => item.description).mkString("; ")
  }
}