package com.evoup

/**
 * Created by yinjia on 2014/12/16.
 */
trait ConsoleLogger3 extends Logged{
  override def log(msg:String) {println(msg)}
}
