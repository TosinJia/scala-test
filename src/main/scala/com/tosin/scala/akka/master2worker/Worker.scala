package com.tosin.scala.akka.master2worker

import java.util.UUID

import akka.actor.{Actor, ActorSelection, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

/**
 * https://www.scala-lang.org/api/2.11.8/#scala.concurrent.ExecutionContext
 */
class Worker extends Actor {
  //向master发送消息,需要一个master的引用
  var master:ActorSelection = null
  //唯一的标识符id
  val id = UUID.randomUUID().toString

  //创建woker需要向master注册信息，
  //preStart函数构造器调用后立即运行
  override def preStart(): Unit = {
    //向master发送注册信息
    //获取master的地址
    master = context.system.actorSelection("akka.tcp://MasterActorSystem@localHost:9999/user/Master")
    //发送注册信息
    master ! RegisterWorker(id, "localhost", "2048", "4")
  }

  override def receive: Receive = {
    //接收master的回复信息
    case RegisterdWorker(id) =>
      //启动一个定时任务，提醒worker向master发送心跳 0秒 每隔5秒
      context.system.scheduler.schedule(0 millis, 5000 millis, self, SendHeartBeat)

    //接收提醒发送心跳
    case SendHeartBeat =>
      println("worker HeartBeat")
      //向master发送心跳
      master ! HeartBeat(id)
  }
}

//编写启动worker的程序
object Worker1 extends App {
  var clientPort = 8001

  val configStr =
    s"""
       |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
       |akka.remote.netty.tcp.port = $clientPort
       """.stripMargin

  var config = ConfigFactory.parseString(configStr)
  //创建Actor
  val actorSystem = ActorSystem.create("WorkerActorSystem", config)
  //启动Worker
  actorSystem.actorOf(Props[Worker], name = "Worker")
}