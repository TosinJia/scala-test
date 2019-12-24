package com.tosin.scala.itstart01.d191218


/**
 * 继承
 * 父类 Person 人
 * 子类 Emplyee 员工
 * 定义父类
 */
class Person(val name:String, val age:Int) {

  //定义函数
  def sayHello():String = "hello"+name+"\t"+age
}
/**
 * 定义子类
 * 使用 override 关键字，把子类的属性，覆盖父类的属性
 */
class Emplyee(override val name:String, override val age:Int, val salary:Int) extends Person(name, age){
  override def sayHello(): String = "子类中的sayHello"
}
object Demo1{
  def main(args: Array[String]): Unit = {
    // 创建Person对象
    var p1:Person = new Person("tom", 20)
    println(p1.name+"\t"+p1.age)
    println(p1.sayHello())

    //创建子类对象
    var p2:Person = new Emplyee("tosin", 22, 100)
    println(p2.sayHello())

    //通过匿名子类来实现继承：没有名字的子类
    var p3:Person = new Person("jacky", 33){
      override def sayHello(): String = "匿名子类中的sayHello"
    }
    println(p3.sayHello())
    println(new Person("jacky", 33){
      override def sayHello(): String = "匿名子类中的sayHello"
    }.sayHello())
  }
}


/**
 * 抽象类
 * 父类：抽象类 ----交通工具类
 *
 * 注意：
 * abstract只能修饰类
 * 属性，如果没有初始值，抽象属性； 必须覆盖
 *    有初始值 普通属性 不能覆盖
 *
 * 函数：如果没有函数的实现，抽象函数； 必须覆盖
 *    有函数体 普通函数 不能覆盖
 */
abstract class Vehicle{
  //省略 abstract
  var name:String
  var name1:String = ""
  //定义抽象方法 但不需要实现; 省略 abstract
  def checkType():String
}
//子类：自行车、汽车 从父类继承
class Car extends Vehicle{
  override def checkType(): String = "I am a "+name
  override var name: String = "car"
}
class Bike extends Vehicle {
  override def checkType(): String = "I am a "+name
  override var name: String = "bike"
}
object Demo2{
  def main(args: Array[String]): Unit = {
    var v1:Vehicle = new Car
    println(v1.checkType())

    var v2 = new Bike
    println(v2.checkType())
  }
}