package com.tosin.scala

/**
 * 数组遍历
 */
object Demo14 {
  def main(args: Array[String]): Unit = {
    val b = Array("t1","t2", "t3")
    println("--for循环--")
    for(x <- b) println(x)
    println("--foreach遍历--")
    b.foreach(println)
  }
}
