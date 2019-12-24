package com.tosin.scala.itstart01.d191223

class Fruit
case class Apple(name:String) extends Fruit
case class Banana(name:String) extends Fruit

object Demo1 extends App{
  var a = new Apple("Apple")
  var b = new Banana("Banana")
  println(a.isInstanceOf[Fruit])
//  println(a.isInstanceOf[Banana])
//  println(a.isInstanceOf[Apple])
}

object Demo2{
  def main(args: Array[String]): Unit = {
    /**
     * Error:(21, 12) constructor cannot be instantiated to expected type;
     * found   : com.tosin.scala.itstart01.d191223.Banana
     * required: com.tosin.scala.itstart01.d191223.Apple
     * case Banana(name) => println("香蕉")
     */
//    var a = new Apple("Apple")

    var a:Fruit = new Apple("Apple")
    a match {
      case Apple(name) => println("苹果")
      case Banana(name) => println("香蕉")
      case _ => println("不是Fruit子类")
    }
  }
}

