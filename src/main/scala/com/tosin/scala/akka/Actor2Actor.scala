package com.tosin.scala.akka

import akka.actor.{Actor, ActorRef, ActorSystem, Props}


class A extends Actor {
  override def receive: Receive = {
    case "A1" =>
      println("A:B1")
      sender ! "B1"
    case "A2" =>
      println("A:B3")
      sender ! "B3"
    case "A4" =>
      println("A:bb")
      sender ! "bb"
    case "bb" =>
      println("A:bb")
      sender ! "bb"
      //结束
      context.stop(self)
  }
}
class B(a: ActorRef) extends Actor {
  override def receive: Receive = {
    case "B1" =>
      println("B:A2")
      a ! "A2"
    case "B2" =>
      println("B:A3")
      a ! "A3"
    case "B3" =>
      println("B:A4")
      a ! "A4"
    case "bb" =>
      println("B:bb")
//      a ! "bb"
      // 结束
      context.stop(self)
  }
}

//创建一个消息平台
//正常
object Actor2Actor extends App {
  val system = ActorSystem("towActor")
  val a:ActorRef = system.actorOf(Props[A], "a")
  // 获取A的ActorRef
  var b = system.actorOf(Props(new B(a)), "b")

  b ! "B1"
}
