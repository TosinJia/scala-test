package com.tosin.scala.itstart01.d191218

import scala.collection.mutable.ArrayBuffer

/**
 * 内部类
 *
 * 需求：定义一个学生类，同时要保存学生的成绩信息
 */
class Student2 {
  //定义学生属性
  private var stuName:String = "tosin"
  private var stuAge:Int = 20

  // 定义一个数组保存学生的课程成绩
  private var courseList = new ArrayBuffer[Course]()

  // 定义一个函数，用于添加学生的课程成绩
  def addNewCourse(cname:String, grade:Int) = {
    var c = new Course(cname, grade)
    courseList += c
  }

  // 定义课程类:主构造器，即把属性写在类名后面
  class Course(var couseName:String, var grade:Int){}

}

object Student2{
  def main(args: Array[String]): Unit = {
    //测试程序 创建学生对象
    var s = new Student2

    //给学生添加课程信息
    s.addNewCourse("c1", 80)
    s.addNewCourse("c2", 90)
    s.addNewCourse("c3", 100)

    println(s.stuName + "\t" + s.stuAge)
    println("-------课程信息----------")
    for(c <- s.courseList){println(c.couseName + "\t" + c.grade)}
  }
}
