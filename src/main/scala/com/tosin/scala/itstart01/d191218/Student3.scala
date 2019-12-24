package com.tosin.scala.itstart01.d191218

/**
 * 类的主构造器和辅助构造器
 */
class Student3(var stuName:String, var age:Int) {
  //属性
  private var gender:Int = 1

  /**
   * 定义辅助构造器，辅助构造器可以有多个；需要依赖构造器
   * 辅助构造器就是一个函数，只不过这个函数的名字叫 this
   */
  def this(age:Int){
    //相当于 new student3("tosin",age)
    this("tosin", age)
    println("这是辅助构造器 this(age:Int)")
  }

  def this(){
    this(10)
    println("这是辅助构造器 this()")
  }
}
object Student3{
  def main(args: Array[String]): Unit = {
    //使用主构造器创建学生对象
    var s1 = new Student3("tom", 22)
    println(s1.stuName+"\t"+s1.age+"\t"+s1.gender)

    //使用辅助构造器创建学生对象
    var s2 = new Student3(30)
    s2 = new Student3
    s2.gender = 0
    s2.stuName = "john"
    println(s2.stuName+"\t"+s2.age+"\t"+s2.gender)
  }
}