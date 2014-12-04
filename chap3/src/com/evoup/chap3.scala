package com.evoup
import scala.collection.mutable.ArrayBuffer
import scala.collection.JavaConversions.bufferAsJavaList
import scala.collection.mutable.ArrayBuffer

/**
 * Created by yinjia on 2014/12/2.
 */
object chap3 {
  def main(args: Array[String]): Unit = {
    printf("test")
    val nums=new Array[Int] (10)

    val a=new Array[String](10)
    a(0)="Hello"
    a(1)="World"
    printf("a:%s\n",a)
    var s=Array("Hello","World")
    var b=ArrayBuffer[Int] ()
    var b1=new ArrayBuffer[Int]
    /*追加一个元素*/
    b+=1
    b1+=1
    printf("b:%s\n",b)
    printf("b1:%s\n",b1)

    /*追加任意数组*/
    var b2={b1++=Array(147,2048,1456,3444,3335,4564)}
    printf("b2:%s\n",b2)
    b2.trimEnd(3)
    printf("b2 after trimEnd 3 element:%s\n",b2)

    /*数组遍历*/
    for (i<-0 until b2.length) {
      printf("b2 element:%s\n",b2(i))
    }

    /*数组转换*/
    val ar = Array(2,3,5,7,11)
    for (i<-0 until ar.length) {
      printf("ar element:%s\n",ar(i))
    }

    /*for yield创建与原始集合相同的新集合，yield之后的表达式包含在结果内，每次迭代对应一个*/
    val result=for (elem <- ar) yield 2*elem
    for (i<-0 until result.length) {
      printf("result element:%s\n",result(i))
    }

    /*带守卫的for yield*/
    var result2=for(elem<-ar if elem%2==0) yield 2*elem
    for (i<-0 until result2.length) {
      printf("result2 element:%s\n",result2(i))
    }
   var result3 = ar.filter { _ % 2 == 0}.map(2 * _)
    for (i<-0 until result3.length) {
      printf("result3 element:%s\n",result3(i))
    }

    /*简单常用算法*/
    /*最大*/
    printf("max:%d\n",Array(1,3,5,67).max)
    /*求和*/
    printf("sum:%d\n",Array(1,3,5,67).sum)
    /*升序*/
    var sortedA=Array(3,67,5,1).sorted
    for (i<-0 until sortedA.length) {
      printf("sortedA element:%s\n",sortedA(i))
    }
    /*降序*/
    var rsortedA=Array(3,67,5,1).sortWith(_ > _)
    for (i<-0 until rsortedA.length) {
      printf("rsortedA element:%s\n",rsortedA(i))
    }

    /*快速排序*/
    var arr = Array(1,7,2,9)
   scala.util.Sorting.quickSort(arr)
    for (i<-0 until arr.length) {
      printf("arr with quicksort element:%s\n",arr(i))
    }
    printf(arr.mkString(" and "))

    //多维度数组
    var arrmul=new Array[Array[Int]](10)
    for (i<-0 until arrmul.length) {
      arrmul(i)=new Array[Int](i+1)
    }

    //和java交互
    val command=ArrayBuffer("ls","-la","/tmp")
    val pb=new ProcessBuilder(command)
  }
}