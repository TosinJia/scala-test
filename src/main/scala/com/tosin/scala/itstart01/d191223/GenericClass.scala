package com.tosin.scala.itstart01.d191223

/**
 * 需求：定义一个类，来操作整数
 */
class GenericClassInt {
  private var content:Int = 10
  def set(value:Int) = {content=value}
  def get():Int = {content}
}

/**
 * 需求：定义一个类，来操作字符串
 */
class GenericClassString {
  private var content:String = "hello"
  def set(value:String) = {content=value}
  def get():String = {content}
}

/**
 * 问题：能不能定义一个类，既可以操作整数，也可以操作字符串
 * 解决:定义泛型类
 * @tparam T
 */
class GenericClass[T]{
  //初始值用 _ 表示
  private var content:T = _
  def set(value:T) = {content=value}
  def get():T = {content}
}

object GenericClass {
  def main(args: Array[String]): Unit = {
    //相当于 GenericClassInt
    var v1 = new GenericClass[Int]
    v1.set(1000)
    println(v1.get())

    var v2 = new GenericClass[String]
    v2.set("scala")
    println(v2.get())
  }
}
