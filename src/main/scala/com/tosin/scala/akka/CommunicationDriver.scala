package com.tosin.scala.akka

import akka.actor.{ActorSystem, Props}

object CommunicationDriver {
  //1. 创建ActorSystem，用ActorSystem创建Actor
  private val cFactory = ActorSystem("cFactory")
  //2. Actor通过ActorRef发送消息
  private val tosinRef = cFactory.actorOf(Props[TosinActor], "tosin")
  //3. Nana需要接收Tosin发送的消息
  private val nanaRef = cFactory.actorOf(Props(new NanaActor(tosinRef)), "Nana")
  def main(args: Array[String]): Unit ={
    //Tosin自己给自己发送消息
//    tosinRef ! "我爱Tosin"

    //Nana给Tosin方消息
    nanaRef ! "你好，我是Nana"
  }
}
