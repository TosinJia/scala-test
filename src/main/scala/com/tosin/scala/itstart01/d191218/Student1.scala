package com.tosin.scala.itstart01.d191218

/**
 * 代表学生信息
 */
class Student1 {
  //定义学生属性
  private var stuId:Int = 0
  private var stuName:String = "Tosin"
  private var age:Int = 20

//  private val sex:String = "man"
  private[this] val sex:String = "man"

  //定义方法（函数） get set
  def getStuName():String = stuName
  def setStuName(newName:String) = {
    this.stuName = newName
  }
}

/**
 * 如果要开发main方法，需要将main方法定义在该类的伴生对象中，即：object对象中
 *
 * 测试student1类，创建main函数，写到object里面
 * 注意object和class的名字 可以不一样 如果一样的话，这个object就叫做class的伴生对象
 */
object Student1{
  def main(args: Array[String]): Unit = {
    // 创建一个学生对象
    var s1 = new Student1
    //访问属性并输出
    println(s1.getStuName())
    //访问set方法
    s1.setStuName("tosin")
    println(s1.getStuName())

    println("-----访问私有属性--------")
    s1.age = 22
    //不能赋值
//    s1.sex = "female"
//    println(s1.stuName+"\t"+s1.stuId+"\t"+s1.age+"\t"+s1.sex)
    println(s1.stuName+"\t"+s1.stuId+"\t"+s1.age)
  }

}
