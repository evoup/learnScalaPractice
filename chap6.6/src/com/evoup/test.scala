package com.evoup
import TrafficLightColor._
/**
 * Created by yinjia on 2014/12/12.
 */
object test {
  def main(args: Array[String]): Unit = {
    var action=""
    action=doWhat(Red)
    println("action:"+action)
    action=doWhat(Yellow)
    println("action:"+action)
  }

  def doWhat(color: TrafficLightColor) ={
    if (color==TrafficLightColor.Red) "Stop"
    else if (color == Yellow) "hurry up"
    else "go"
  }
}
