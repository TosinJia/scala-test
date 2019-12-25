package com.tosin.scala.akka

import akka.actor.{Actor, ActorSystem, Props}

import scala.io.StdIn

object CallMe {
  //1. 创建ActorSystem 用ActorSystem 创建Actor
  private val acFactory = ActorSystem("acFactory")
  //2. Actor通过ActorRef发送消息
  private val callRef = acFactory.actorOf(Props[CallMe], "CallMe")

  def main(args: Array[String]): Unit = {
    //3. 发送消息
//    callRef ! "你好！"
//    callRef ! "你是谁？"
//    callRef ! "停止"

    //3.1 循环发送消息
    var line = ""
    while(!line.equals("停止")){
      println("请输入：")
      line = StdIn.readLine()
      callRef ! line
    }
  }
}

class CallMe extends Actor {
  //接收消息并且处理消息
  override def receive: Receive = {
    case "你好！" => println("hello!")
    case "你是谁？" => println("who are you?")
    case "停止" => {
      //关闭代理ActorRef
      context.stop(self)
      //关闭ActorSystem
      context.system.terminate()
    }
    case _ => println("no support!")
  }
}