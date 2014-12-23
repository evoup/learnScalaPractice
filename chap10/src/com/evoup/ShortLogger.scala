package com.evoup

/**
 * Created by yinjia on 2014/12/17.
 */
trait ShortLogger extends Logged{
  val maxlength=15
  override def log(msg:String): Unit ={
    super.log(
      if(msg.length<=maxlength) msg
      else msg.substring(0,maxlength-3)+"..."
    )
  }
}
