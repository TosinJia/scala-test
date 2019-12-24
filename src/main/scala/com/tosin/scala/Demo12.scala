package com.tosin.scala

import java.io.{File, FileInputStream, PrintWriter}

import scala.io.Source.{fromFile, fromURL}

/**
 * 流
 */
object Demo12 {
  def main(args: Array[String]): Unit = {
    try{
      val words = scala.io.Source.fromFile("E:\\BaiduNetdiskDownload\\data\\student.txt").mkString
      println(words)

      println("--直接打印文本--")
      val words1 = fromFile("E:\\BaiduNetdiskDownload\\data\\student.txt")
//      println(words1)
//      println(words1.mkString)
      println("--打印每行数据--")
      var lines = words1.getLines()
//      lines.foreach(println)

      var i = 1
      for(line <- lines){
        println(s"第${i}行：${line}")
        i+=1
      }
    }


    // 调用java对象
    val file = new File("E:\\BaiduNetdiskDownload\\data\\student.txt")
    val in:FileInputStream = new FileInputStream(file)
    var buffer = new Array[Byte](file.length().toInt)
    in.read(buffer)
    println(buffer.length)

    println("--读取URL--")
    var url = fromURL("https://www.baidu.com/", "UTF-8")
    println(url.mkString)

    // 写入,如果写入失败，管理员方式启动IDEA
    val printWriter = new PrintWriter("E:\\BaiduNetdiskDownload\\data\\student1.txt")
    for(i <- 0 to 10){
      printWriter.println(i)
    }
    printWriter.close()

  }
}
