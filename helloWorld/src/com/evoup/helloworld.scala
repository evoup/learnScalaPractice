package com.evoup
import scala.math._
import scala.io.StdIn._
import scala.util.control.Breaks._

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
    printf("\n--------------\ndistance:%s\n",distance)

    val name = readLine("Your name: ")
    print("Your age: ")
    val age=readInt()
    printf("Hello,%s!Next year,your will be %d.\n",name,age+1)
    val ss ="hello"
    var sum=0
    for (j<-0 until ss.length)
      sum+=ss(j)
    printf("sum:%d",sum)
    /* breakable需要载入break*/
    breakable {
      for (j<-0 to 10) {
        printf("j:%d",j)
        if(1==1) break;
        printf("this will not reach")
      }
    }
    /*高级for*/
    printf("\n----------------------\n")
    printf("for(i<-1 to 3;j<-1 to 3 if i!=j) print ((10*i+j)+\"\")")
    printf("\n----------------------\n")
    for(i<-1 to 3;j<-1 to 3 if i!=j) print ((10*i+j)+"")
    printf("\n----------------------\n")
    printf("for(i<-1 to 3;j<-1 to 3 if i!=j) print ((10*i+j)+\"\")")
    printf("\n----------------------\n")
    printf("for (i<-1 to 3;from=4-i;j<-from to 3) print ((10*i+j)+\" \")")
    printf("\n----------------------\n")
    for (i<-1 to 3;from=4-i;j<-from to 3) print ((10*i+j)+" ")
    printf("\n----------------------\n")
    printf("abs(%s):%s\n",12.1,abs(12.1))
    printf("fac(%d):%d\n",3,fac(3))
    printf("decorate(%s,%s,%s):%s\n","test","<<<",">>>",decorate("test","<<<",">>>"))
    //传统方式
    printf("sumx(1,2,3,4,5):%d\n",sumx(1,2,3,4,5))
    //参数序列方式
    printf("sumx(1 to 5:_*):%d",sumx(1 to 5:_*))

    //懒值(推迟到运行后再初始化，少用也有开销)
    //lazy val words=scala.io.Source.fromFile("/path/to/file").mkString
    //调用有异常捕捉的过程
    printf("sqrtWithException(3):%s",sqrtWithException(3))
  }

  /*无块的方法*/
  def abs(x: Double) = if (x >= 0) x else -x

  /*有块的方法*/
  def fac(n: Int) = {
    var r=1
    for (i<-1 to n) r=r*i
    r
  }

  /*默认参数的方法*/
  def decorate(str:String,left:String="[",right:String="]") = {
    left+str+right
  }

  /*可接受可变成参数*/
  def sumx(args: Int*) = {
    var result=0
    for(arg<-args) result+=arg
    result
  }

  //不返回的任何信息的过程
  def x() {}

  //抛异常
  def sqrtWithException(x:Int):Unit = {
    if (x<0) throw new IllegalArgumentException("x should not be negative")
    else sqrt(x)
  }
}
