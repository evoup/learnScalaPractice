package com.evoup

/**
 * Created by yinjia on 2014/12/16.
 */
trait Logger {
  def log(msg:String) //默认为抽象方法，scala中特质也可以进行实现，而不一定非得抽象，所以 在后面加上{print(msg)}也是可以的
}
