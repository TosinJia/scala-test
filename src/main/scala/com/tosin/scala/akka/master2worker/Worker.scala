package com.tosin.scala.akka.master2worker

import java.util.UUID

import akka.actor.{Actor, ActorSelection, ActorSystem, Props}
import com.tosin.scala.akka.master2worker.Master.config
import com.typesafe.config.ConfigFactory

import scala.concurrent._

class Worker extends Actor {
  //向master发送消息,需要一个master的引用
  var master:ActorSelection = null
  //唯一的标识符id
  val id = UUID.randomUUID().toString

  //创建woker需要向master注册信息，
  // 构造器调用后立即运行
  override def preStart(): Unit = {
    //向master发送注册信息
    //获取master的地址
    master = context.system.actorSelection("akka.tcp://MasterActorSystem@localHost:8888/user/Master")
    //发送注册信息
    master ! RegisterWorker(id, "localhost", "2048", "4")

  }

  override def receive: Receive = {
    //接收master的回复信息
    case RegisterdWorker(id) =>
      //启动一个定时任务，提醒worker向master发送心跳 0秒 每隔5秒
      context.system.scheduler.schedule(0 millis, 5000 millis, self, SendHeartBeat)

    //接收
    case SendHeartBeat =>
      println("worker HeartBeat")
      master ! HeartBeat(id)

  }
}

//编写启动worker的程序
object Worker extends App {
  var clientPort = 8001

  val configStr = s""
  var config = ConfigFactory.parseString(configStr)

  //创建Actor
  val actorSystem = ActorSystem.create("WorkerActorSystem", config)
  //启动Worker
  actorSystem.actorOf(Props[Worker], name = "Worker")
}