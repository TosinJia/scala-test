package com.tosin.scala
import util.control.Breaks._

object Demo11 {

  def main(args: Array[String]): Unit = {
    var count = 0
    //100 until 200 [100, 200)
    //100 to 200  [100,200]
    for(x <- 100 until 200){
      var status = false
      breakable{
        for( y <- 2 until x){
          if(x%y==0){
            status = true
            break
          }
        }
      }

      if(!status){
        print(s"${x},")
        count += 1
      }
    }
    println("");
    println(s"素数个数：${count}")
  }
}
