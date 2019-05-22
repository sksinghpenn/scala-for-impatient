package com.lifotech.scala.impatient.ch05


import scala.beans.BeanProperty

// Question 5. Make a class Student with read-write JavaBeans properties name (of type String) and id (of type Long).
// What methods are generated? (Use javap to check.) Can you call the JavaBeans getters and setters in Scala Should you?

class Student(@BeanProperty var name: String, @BeanProperty var id: Long) 
