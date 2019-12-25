package com.tosin.scala.akka

import akka.actor.Actor

class TosinActor extends Actor{
  override def receive: Receive = {
    case "你好，我是Nana" => {
      println("你好，我是Tosin")
    }
    case "我爱Tosin" => {
      println("Tosin也爱Nana")
    }
  }
}
