package com.evoup

/**
 * Created by yinjia on 2014/12/17.
 */
trait TimestampLogger extends Logged{
  override def log(msg:String): Unit ={
    super.log(new java.util.Date()+" "+msg)
  }
}
