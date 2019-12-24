package com.tosin.scala.itstart01.d191223

/**
 * 模式匹配
 */
object MatchTest {
  def main(args: Array[String]): Unit = {
    //1 相当于switch case
    var chi = '+'
    // 标识符 判断chi 如果 - 则赋值为 -1
    var sign = 0
    chi match {
      case '+' => sign = 1
      case '-' => sign = -1
      // _ 表示其他情况
      case _ => sign = 0
    }
    println(sign)
    //2、scala的守卫：匹配某种类型的所有值。 case _ if
    // 匹配所有的数字 ch2
    var ch2 = '*'
    ch2 = '5'
    var digit:Int = -1
    ch2 match {
      case '+' => println("这是一个加号")
      case '-' => println("这是一个减号")
      // _ 表示其他情况
      case _ if Character.isDigit(ch2) => digit = Character.digit(ch2, 10)
      case _ => println("其他")
    }
    println(digit)

    // 3 在模式匹配中 使用变量
    var myStr = "hello world"
    myStr(7) match {
      case '+' => println("这是一个加号")
      case '-' => println("这是一个减号")
      case ch123 => println(ch123)
    }

    // 4 instanceOf 匹配类型
    var v4:Any = 1000
    v4 match {
      case x:Int => println("这是一个整数")
      case s:String => println("这是一个字符串")
      case _ => println("其他类型")
    }


    // 5 匹配数组和列表
    var myArray = Array(1,2,3)
    myArray = Array(0)
    myArray = new Array(1)
    myArray(0)=1
    myArray match {
      case Array(0) => println("数组中只有一个0")
      case Array(x,y) => println("数组中包含2个元素")
      case Array(x,y,z) => println("数组中包含3个元素")
      case Array(x,_*) => println("这是数组，包含多个元素")
    }

    var myList = List(1,2,3)
    myList = List(0)
//    myList = List(1)
    myList match{
      case List(0) => println("列表中只有一个0")
      case List(x,y) => println("列表中包含2个元素，和是："+(x+y))
      case List(x,y,z) => println("列表中包含3个元素，和是："+(x+y+z))
      case List(x,_*) => println("这是列表，包含多个元素，和是："+myList.sum)
    }
  }
}
