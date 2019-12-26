package com.tosin.scala.akka.master2worker

import akka.actor.{Actor, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

import scala.collection.mutable
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

class Master extends Actor {
  //worker列表
  var idWorker = new mutable.HashMap[String, WorkerInfo]

  //保存worker的集合
  val workers = new mutable.HashSet[WorkerInfo]

  //定义一个超时时间
  val WORKER_OUTTIME = 10*1000

  override def preStart(): Unit = {
    //master提醒自己检查worker是否失效
    context.system.scheduler.schedule(5 millis, WORKER_OUTTIME millis, self, CheckOfTimeOutWorker)
  }

  override def receive: Receive = {
    // 接收worker的注册信息
    case RegisterWorker(id, workerHost, memory, cores) => {
      //判断worker是否存在
      if (!idWorker.contains(id)) {
        val worker = new WorkerInfo(id, workerHost, memory, cores)
        workers.add(worker)
        idWorker(id) = worker
        println("new RegisterWorker" + worker)
        //回复消息
        sender ! RegisterdWorker(worker.id)
      }
    }
    // 接收worker心跳
    case HeartBeat(id) =>
      val workerInfo = idWorker(id)
      println("get heatbeat from " + workerInfo)
      //更新心跳时间
      workerInfo.lastHeartBeat = System.currentTimeMillis()

    case CheckOfTimeOutWorker =>
      //获取一个最新的时间
      val currentTime = System.currentTimeMillis()
      //遍历workers，将过滤出失效的worker
      val toRemove = workers.filter(workerinfo => currentTime - workerinfo.lastHeartBeat > WORKER_OUTTIME).toArray
      //循环删除失效的worker
      for (worker <- toRemove) {
        workers -= worker
        idWorker.remove(worker.id)
      }
      //打印存活worker数
      println("worker size: " + workers.size)

  }
}

//编写master启动程序
object Master extends App {
  val host = "localHost"
  val port = 9999
  //创建Actor System的参数
  val configStr =
    s"""
       |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
       |akka.remote.netty.tcp.hostname = "$host"
       |akka.remote.netty.tcp.port = "$port"
       """.stripMargin

  var  config = ConfigFactory.parseString(configStr)

  //创建Actor
  val actorSystem = ActorSystem.create("MasterActorSystem", config)

  //启动Master
  actorSystem.actorOf(Props[Master], name = "Master")
}