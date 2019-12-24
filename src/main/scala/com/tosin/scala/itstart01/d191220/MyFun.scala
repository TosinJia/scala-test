package com.tosin.scala.itstart01.d191220

/**
 * 1、Scala中的函数
 * 在Scala中，函数是“头等公民”，就和数字一样。可以在变量中存放函数，即：将函数作为变量的值（值函数）
 */
object MyFun {
  //定义函数
  def myFun(name:String):String = {
    "Hello "+name
  }

  def main(args: Array[String]): Unit = {
    println(myFun("tosin"))
    println("----")
    //值函数，将函数作为变量的值
    var a1 = myFun("tom")
    println(myFun(a1))
  }
}
