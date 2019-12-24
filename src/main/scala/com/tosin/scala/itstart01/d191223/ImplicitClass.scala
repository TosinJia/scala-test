package com.tosin.scala.itstart01.d191223

/**
 * 隐式类
 * 需求，通过n.add(m)实现n+m的值，也就是实现两个数的和
 */
object ImplicitClass {
  implicit class ADD1(x:Int){
    def add(a:Int) = a + x
  }

  def main(args: Array[String]): Unit = {
    println(5.add(10))
  }
}
