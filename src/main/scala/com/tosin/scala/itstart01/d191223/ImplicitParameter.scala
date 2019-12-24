package com.tosin.scala.itstart01.d191223

/**
 * 隐式参数
 */
object ImplicitParameter {
  implicit var n = "张三"

  def ss(implicit name:String) = {
    println("我的名字："+name)
  }

  def main(args: Array[String]): Unit = {
    ss("李四")
    ss

    println(smaller(1,2))
    println(smaller(1l,2l))
    println(smaller("1","2"))
  }


  /**
   * 定义一个方法可以进行任意类型数据的比较
   */
  def smaller[T](x:T,y:T)(implicit order:T => Ordered[T]) = {
    if(x>y) x else y
  }
}


