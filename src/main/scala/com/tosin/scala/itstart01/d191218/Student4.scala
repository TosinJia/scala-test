package com.tosin.scala.itstart01.d191218

class Student4(var stuName:String)

/**
 * 定义Student4的apply方法
 */
object Student4{
  def apply(name:String) = {
    println("调用了apply方法")
    new Student4(name)
  }

  def main(args: Array[String]): Unit = {
    // 使用主构造器创建学生对象
    var s1 = new Student4("Tom")
    println(s1.stuName)

    // 通过apply方法创建学生对象
    var s2 = apply("tosin")
    println(s2.stuName)
  }

}
