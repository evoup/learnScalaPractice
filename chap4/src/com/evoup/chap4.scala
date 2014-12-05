package com.evoup
import scala.collection.JavaConversions.mapAsScalaMap
import  scala.collection.JavaConversions.propertiesAsScalaMap
import scala.collection.JavaConversions.mapAsJavaMap
import java.awt.font.TextAttribute._
/**
 * Created by yinjia on 2014/12/4.
 */
object chap4 {
  def main(args: Array[String]): Unit = {
    /*常规的定义方式*/
    val scores=Map("Alice"->10,"Bob"->3,"Cindy"->8)
    /*空的map*/
    val scores2=new scala.collection.mutable.HashMap[String,Int]
    /*第二种方式*/
    val scores3=Map(("Alice",10),("Bob",3),("Cindy",8))
    val bobsScore=scores("Bob")
    printf("bobsScore:%s\n",bobsScore)
    val bobsScore2=if (scores.contains("Bob")) scores("Bob") else 0
    printf("bobsScore2:%s\n",bobsScore2)
    /*根据有的key取值，否则置0*/
    val bobsScore3=scores.getOrElse("Bob",0)
    /*修改，必须是HashMap*/
    scores2("Bob")=10
    printf("get new val of Bob:%s\n",scores2("Bob"))
    /*添加元素*/
    scores2+=("Bob"->11,"Fred"->7)
    printf("scores2: ")
    print(scores2)
    /*删除元素*/
    scores2-="Bob"
    printf("\nscores2: ")
    print(scores2)
    /*相加*/
    var newScores=scores2+("Bob"->13,"Fred"->9,"Max"->21,"Hison"->47,"Conan"->19)
    printf("\nnewScores: ")
    print(newScores)
    /*相减*/
    newScores=newScores-"Bob"
    printf("\nnewScores after minus Bob: ")
    print(newScores)
    /*遍历*/
    for((k,v)<-newScores) {
      printf("\nk:%s v:%s",k,v)
    }
    /*只要访问键,将返回Set类型*/
    printf("\n %s",newScores.keySet)
    /*只要访问值，讲返回HashMap类型*/
    print("\n"+newScores.values)
    /*反转，相当于php的array_flip*/
    var flipedArr=for ((k,v) <-newScores) yield (v,k)
    print("\n"+flipedArr)
    //按照key排列好的map
    val scoresx=scala.collection.immutable.SortedMap("Alice"->10,"Fred"->7,"Bob"->3,"Cindy"->8)
    print("\nscoresx:"+scoresx)
    /*和JAVA交互*/
    val scoresx2: scala.collection.mutable.Map[String,Int] = new java.util.TreeMap[String,Int]
    val props: scala.collection.Map[String,String] =System.getProperties()
    print("\nprops:"+props)
    val attrs=Map(FAMILY->"Serif",SIZE->12)
    val font=new java.awt.Font(attrs)//该方法预期一个java映射
    //元组
    var t=(1,3.14,"Fred")
    var second=t._2
    print("\n second:"+second)
    var (firstVal,secondVal,thirdVal) = t
    printf("\nfirstVal:%s secondVal:%s thirdVal:%s",firstVal,secondVal,thirdVal)
    //元组可以被修改吗？?
    //和erlang一样仅取部分
    var t1=(2,3,5,7,9)
    var (_,_,_,_,value)=t1
    print("\nvalue:"+value)
    //StringOps的partiton可以作分隔操作
    var partedVal="New York".partition(_.isUpper)
    print("\npartedVal:"+partedVal)

    //相当于php的array_combine的元组合并操作
    val symbols=Array("<","-",">")
    print("\nsymbols:"+symbols)
    val counts=Array(2,10,2)
    print("\ncounts:"+counts)
    val pairs=symbols.zip(counts)
    print("\npairs:"+pairs)
    for ((s,n)<-pairs) print(s*n)
  }
}