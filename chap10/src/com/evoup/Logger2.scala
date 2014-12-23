package com.evoup

/**
 * Created by yinjia on 2014/12/17.
 */
trait Logger2 {
  def log(msg:String)
  def info(msg:String) {log("INFO:"+msg)}
  def warn(msg:String) {log("WARN:"+msg)}
  def severe(msg:String) {log("SEVERE:"+msg)}
}
