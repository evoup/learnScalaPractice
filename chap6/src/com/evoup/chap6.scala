package com.evoup

/**
 * Created by yinjia on 2014/12/5.
 */
object chap6 {
  def main(args: Array[String]): Unit = {
    //scala
    var acc=Accounts.newUniqueNumner()
    println("acc:"+acc)
    acc=Accounts.newUniqueNumner()
    println("acc:"+acc)
  }
}

/*在应用程序中创建一个新的唯一账号*/
object Accounts {
  private var lastNumber=0
  def newUniqueNumner() = {
    lastNumber+=1
    lastNumber
  }
}

/*伴生对象例子*/

class Account { //有伴生对象的类，可以访问伴生对象的私有特性
  val id=Account.newUniqueNumber2() //必须用伴生对象.方法的方式来访问伴生对象的方法
  private var balance=0.0
  def deposit(amount: Double) {balance+=amount}
}

object Account { //伴生对象
  private var lastNumber=0
  private def newUniqueNumber2()={lastNumber+=1;lastNumber}
}

abstract class UndoableAction(val description: String) {
  def undo(): Unit
  def redo(): Unit
}

