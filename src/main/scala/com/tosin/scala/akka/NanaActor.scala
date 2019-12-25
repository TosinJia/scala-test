package com.tosin.scala.akka

import akka.actor.{Actor, ActorRef}

class NanaActor(val h:ActorRef) extends Actor {
  override def receive: Receive = {
    case "你好，我是Nana" => {
      //Nana发送消息给Tosin
      h ! "我爱Tosin"
    }
  }
}
