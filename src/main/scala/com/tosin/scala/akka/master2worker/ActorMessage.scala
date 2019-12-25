package com.tosin.scala.akka.master2worker

//向master注册
case class RegisterWorker(val id:String, val workerHost:String, val memory:String, val cores:String)
//Master返回一个确认
case class RegisterdWorker(id:String)
//worker自己触发消息
case class SendHeartBeat()
//worder向master发送心跳
case class HeartBeat(id:String)
//master超时检查消息
case class CheckOfTimeOutWorker()

class ActorMessage {

}
