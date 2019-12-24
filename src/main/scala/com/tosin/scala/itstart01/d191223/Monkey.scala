package com.tosin.scala.itstart01.d191223


/**
 * 隐式转换函数
 */
class Monkey(f:FruitM) {
  def eat(): Unit ={
    println("猴子吃"+f.getFruitName)
  }
}

//水果类
class FruitM(name:String){
  def getFruitName:String = {name}
}

/**
 * 测试
 * 需求：猴子吃香蕉
 */
object Test{
  def main(args: Array[String]): Unit = {
    //正常调用
    var monkey = new Monkey(new FruitM("香蕉"))
    monkey.eat()

    // 问题：能不能定义香蕉类的时候直接调用吃的方法
    // 定义隐式函数
    val f:FruitM = new FruitM("香蕉")
    f.eat()
  }

  implicit def fruitM2Monkey(f:FruitM):Monkey={
    new Monkey(f)
  }
}
