package com.evoup
import scala.collection.mutable.ArrayBuffer

/**
 * Created by yinjia on 2014/12/2.
 */
object chap3 {
  def main(args: Array[String]): Unit = {
    printf("test")
    val nums=new Array[Int] (10)

    val a=new Array[String](10)
    var s=Array("Hello","World")
    var b=ArrayBuffer[Int] ()
    var b1=new ArrayBuffer[Int]
    /*追加一个元素*/
    b+=1
    b1+=1
    printf("b:%s\n",b)
    printf("b1:%s\n",b1)

    /*追加任意数组*/
    var b2={b1++=Array(147,2048)}
    printf("b2:%s\n",b2)

  }
}