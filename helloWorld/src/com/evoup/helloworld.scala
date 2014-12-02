package com.evoup
import scala.math._
/**
 * Created by yinjia on 2014/12/2.
 */
object helloworld {
  def main(args: Array[String]): Unit = {
    var x =147
    var s = if(x>0) x else -1
    println("hello world")
    // val height = 1.9d
    // var name = "evoup"
    // println(f"$name%s is $height%2.2f $s%d meters tail")
    val d = {val x=1;val y=2;sqrt(x+y)}
    printf("Hello, %s! You are %d years old.\n","evoup",34)
    for (i<- 1 to 10) {
      printf("i:%d",i)
    }
    s=1+2+ //长语句
    3
    printf("\n--------------\ns:%d",s)
    val distance={val dx=1;val dy=2;sqrt(dx+dy)}
    printf("\n--------------\ndistance:%s",distance)
  }
}
