package com.tosin.scala

object Demo10 {
  def main(args: Array[String]): Unit = {
    val list = List("tosin","tsn","tn")
    println("--for 1--")
    for(s <- list){
      println(s)
    }
    println("--for 2--")
    for(s <- list) println(s)
    println("--for 3--")
    for{
      s <- list
      if(s.length > 3)} println(s)

    println("--for 4--")
    var list1 = for{
      s <- list
      s1 = s.toUpperCase}yield(s1)
    list1.foreach(println)

    println("--while 1--")
    var i = 0
    while(i < list.length){
      println(list(i))
      i += 1
    }

    println("--while 2--")
    i = 0
    do{
      println(list(i))
      i += 1
    }while(i < list.length)
  }
}
