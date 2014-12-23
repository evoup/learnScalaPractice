package com.evoup

/**
 * Created by yinjia on 2014/12/17.
 */
trait TimestampLogger2 extends Logger with Logged{
  abstract override def log(msg:String): Unit ={
    super.log("抽象方法已经重写"+new java.util.Date()+" "+msg)
  }
}


