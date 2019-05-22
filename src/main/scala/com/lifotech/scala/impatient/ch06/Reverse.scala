package com.lifotech.scala.impatient.ch06


// Question 5. Write a Scala application, using the App trait, that prints the command-line arguments in reverse order, separated by spaces.
// For example, scala Reverse Hello World should print World Hello.

object Reverse extends App {
  args.reverse.foreach(x => print(x + " "))
}
