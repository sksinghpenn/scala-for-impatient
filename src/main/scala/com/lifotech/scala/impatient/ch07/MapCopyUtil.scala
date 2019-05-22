package com.lifotech.scala.impatient.ch07

import java.util.{HashMap => JavaHashMap, Map => JavaMap}

import scala.collection.mutable.{Map => ScalaMap}

import scala.collection.JavaConverters._

object MapCopyUtil extends App {



  def copyJavaHasMapElemToScalaMap(javaMap: JavaMap[String, Int]): ScalaMap[String, Int] = javaMap.asScala


}
