package com.tosin.scala

object Demo191218 {
  def main(args: Array[String]): Unit = {
    val matrix = Array.ofDim[Int](3,4)
    matrix(1)(2) = 10
    println(matrix)
  }
}
