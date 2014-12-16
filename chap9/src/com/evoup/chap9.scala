package com.evoup

import java.io.FileInputStream
import java.io.PrintWriter
import scala.io.Source
import scala.reflect.io.File
import scala.collection.mutable.ArrayBuffer
import sys.process._

/**
 * Created by yinjia on 2014/12/15.
 */
object chap9 {
  def main(args: Array[String]) {
    import java.io.File
    chap91
    chap92
    chap93
    chap94
    chap95
    chap96
    chap97_subdirs(new File("c:/test"))
    chap98
    chap99
    chap910
    chap911
  }

  /*读取行*/
  def chap91: Unit = {
    println("chap9.1-----------------")
    val source=Source.fromFile("c:/myfile.txt","UTF-8")
    System.out.println(System.getProperty("user.dir"))
    val lineIterator=source.getLines
    for (l<-lineIterator)
      println(l)
  }

  /*读取字符*/
  def chap92: Unit = {
    println("chap9.2-----------------")
    val source=Source.fromFile("c:/myfile.txt","UTF-8")
    val iter=source.buffered
    while(iter.hasNext) {
        println(iter.head)
      iter.next()
    }
    source.close()
  }

  /*读取词法单元和数字*/
  def chap93: Unit = {
    println("chap9.3-----------------")
    val source=Source.fromFile("c:/myfile.txt","UTF-8")
    val tokens = source.mkString.split("\\s+")
    val numbers=for (w<-tokens) yield w.toDouble
    print(numbers)
    val numbers1=tokens.map(_.toDouble)
    print(numbers1)
  }

  /*从URL读取*/
 def chap94: Unit ={
   println("chap9.4-----------------")
   val source1=Source.fromURL("http://www.baidu.com","UTF-8")
   val source2=Source.fromString("Hello,World!")
   val source3=Source.stdin
 }

  /*读取二进制文件*/
 def chap95: Unit ={
   //val file=new File("haha")
   //val in=new FileInputStream(file)
   //val bytes=new Array[Byte](file.length.toInt)
  }

  /*写入文本文件*/
 def chap96: Unit ={
    println("chap9.6-----------------")
    val out=new PrintWriter("c:/number.txt")
    for(i<-1 to 100) out.println(i)
    out.close
 }

  import java.io.File
  /*访问目录*/
  def chap97_subdirs(dir: File): Iterator[File]={
    val children=dir.listFiles.filter(_.isDirectory)
    children.toIterator++children.toIterator.flatMap(chap97_subdirs _)
  }
  class Person extends Serializable{
    private val friends=new ArrayBuffer[Person]
  }

  /*序列化*/
  def chap98: Unit = {
    println("chap9.8-----------------")
    import java.io._
    val fred=chap96
    val out=new ObjectOutputStream(new FileOutputStream("c:/test/test.obj"))
    out.writeObject(fred)
    out.close()
    val in=new ObjectInputStream(new FileInputStream("c:/test/test.obj"))
    //val savedFred=in.readObject().asInstanceOf[Person]
  }

  /*进程控制*/
  def chap99: Unit = {
    println("chap9.9-----------------")
    //val result="ls -la .." !!
    "ls -la" #> new File("c:/test/outshell.txt") !
  }

  /*正则表达式*/
  def chap910: Unit = {
    println("chap9.10-----------------")
    val numPattern = "[0-9]+".r
    //如果正则表达式包含反斜杠或引号，最好用“原始”字符串语法
    val wsnumwsPattern = """\s+[0-9]+\s+""".r
    for (matchString <- numPattern.findAllIn("99 bottles,98 bottles"))
      println("we find:" + matchString)
    val matches = numPattern.findAllIn("99 bottles,98 bottles").toArray
    for (i <- 0 until matches.length) {
      print("match array[" + i + "]" + matches(i))
    }
    print("\n")
    //查找前几个
    val m1=wsnumwsPattern.findFirstIn("99 bottles,98 bottles")
    println(m1)
    val m2=numPattern.findPrefixOf("99 bottles,98 bottles")
    println(m2)
    //替换
    println(numPattern.replaceFirstIn("99 bottles,98 bottles","XX"))
    println(numPattern.replaceAllIn("99 bottles,98 bottles","XX"))
  }

  def chap911: Unit ={
    //正则表达式组
    val numitemPattern="([0-9]+) ([a-z]+)".r
    //作为提取器
    val numitemPattern(num,item)="99 bottles"
    for(numitemPattern(num,item)<-numitemPattern.findAllIn("99 bottles,98 bottles"))
        println("num:"+num+"item:"+item)
  }

}


