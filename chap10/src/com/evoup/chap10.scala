package com.evoup

/**
 * Created by yinjia on 2014/12/16.
 */
object chap10 {

  def main(args: Array[String]) {
    println("chap10----------------")
    //类中重写特质的方法
    var cl=new ConsoleLogger
    cl.log("hello world\n")

    //类中使用带有实现的特质
    var sa=new SavingsAccount
    sa.withdraw(30.45)

    //对象叠加一个特质
    var sa2 = new SavingsAccount2 with ConsoleLogger3
    sa2.withdraw(30.33)

    //叠加多个特质，从左到右构造,但是串接并去掉重复项，右侧胜出
    val acct1=new SavingsAccount2 with ConsoleLogger3 with TimestampLogger with ShortLogger
    print("acct1:")
    acct1.withdraw(1789.71)
    val acct2=new SavingsAccount2 with ConsoleLogger3 with ShortLogger with TimestampLogger
    print("acct2:")
    acct2.withdraw(1789.71)

    //在特质中重写被继承特质的抽象方法
    print("ts2:")
    val ts2=new SavingsAccount2 with ConsoleLogger3 with TimestampLogger2 with ShortLogger
    ts2.withdraw(3344.12)

    //在类型中重写（富接口的一个方法被重写，其他方法直接调用）
    print("ts3:")
    val ts3=new SavingsAccount3
    ts3.withdraw(12.1)
    ts3.info("test rich interface")

    //调用特质的顺序,无法跑通？
    //print("ts4:")
    //val ts4=new SavingsAccount4
/*    Error:(6, 7) overriding method log in trait FileLogger of type (msg: String)Unit;
    method log in trait ShortLogger of type (msg: String)Unit cannot override a concrete member without a third member that's overridden by both (this rule is designed to prevent ``accidental overrides'')
    class SavingsAccount4 extends Account with FileLogger with ShortLogger{
      ^*/
  }
}
