package com.evoup
import java.io.PrintWriter
import java.util.Date
/**
 * Created by yinjia on 2014/12/17.
 */
trait FileLogger extends Logger{
  val out=new PrintWriter("app.log")
  println("#"+new Date().toString)
  def log(msg:String) {out.println(msg);out.flush()}
}
