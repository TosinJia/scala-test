package com.tosin.scala.itstart01.d191220

/**
 * trait就是抽象类。trait跟抽象类最大的区别：trait支持多重继承（类似java接口）
 * 定义两个父类，定义两个trait
 * 人 动作
 */
trait Human {
  //抽象字段
  val id:Int
  val name:String
}
//定义一个抽象函数
trait Action{
  def getActionName():String
}
//定义子类
//extends Human with Action , Action2 不行
// extends Human with Action with Action2就是多重继承
class Student(val id:Int, val name:String) extends Human with Action{
  //需要实现getActionName方法
  override def getActionName(): String = "Action is running"
}
object Demo1{
  def main(args: Array[String]): Unit = {
    //创建学生对象
    val s1 = new Student(1, "tosin")
    println(s1.id+"\t"+s1.name)
    println(s1.getActionName())
  }
}