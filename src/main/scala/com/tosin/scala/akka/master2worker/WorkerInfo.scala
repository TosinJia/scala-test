package com.tosin.scala.akka.master2worker

//保存worker的基本信息
class WorkerInfo(val id:String, val workerHost:String, val memory:String, val cores:String) {
  //心跳时间
  var lastHeartBeat:Long = System.currentTimeMillis()

  //重写toString
  override def toString: String = {
    s"WorkerInfo(${id} ${workerHost} ${memory} ${cores})"
  }

}
