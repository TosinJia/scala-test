package com.tosin.scala

import java.io.{FileNotFoundException, IOException}

import scala.io.Source.fromFile

/**
 * 异常
 */
object Demo13 {
  def main(args: Array[String]): Unit = {
    try{
      val words1 = fromFile("E:\\BaiduNetdiskDownload\\data\\student2.txt")
      println(words1.mkString)
    }catch {
      case e: FileNotFoundException => {
        println("file not found")
      }
      case e: IOException =>{
        println("IO Exception")
      }
    }finally{
      println("finally")
    }
  }
}
