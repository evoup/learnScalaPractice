package com.evoup

/**
 * Created by yinjia on 2014/12/16.
 */
class ConsoleLogger extends Logger with Cloneable with Serializable{
  def log(msg:String) {print(msg)} //重写特质的log方法
}
