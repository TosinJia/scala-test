package com.tosin.scala.itstart01

/**
 * 包可以包含类、对象和特质，但不能包含函数或者变量的定义。很不幸，这是Java虚拟机的局限
 * 把工具函数或者常量添加到包而不是某个Utils对象，这是更加合理的做法。Scala中，包对象的出现正 是为了解决这个局限。
 *
 * Scala中的包对象：常量，变量，方法，类，对象，trait（特质）
 */
package object test {
  //常量
  val x:Int = 0
  //变量
  var y:String = "HelloWorld"
  //方法
  def helloworld():String = "helloworld"
  //类
  class MyTestClass{}
  //对象
  object MyTestObject{}
  //特质
  trait MyTestTrait{}
}
object Test{
  def main(args: Array[String]): Unit = {
    println(test.x)
  }
}
