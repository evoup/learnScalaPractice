package com.evoup
import scala.beans.BeanProperty

/**
 * Created by yinjia on 2014/12/5.
 */
object chap5 {
  def main(args: Array[String]): Unit = {
    //所有类具有公共可见性
    class Counter{
      private var value=0
      def increment() {value+=1}
      def current()=value //也可以def current=value，不过调用方法的时候也要不打括号
    }
    var myCounter=new Counter
    myCounter.increment()
    println(myCounter.current())
    myCounter.increment()
    println(myCounter.current) //无参方法也可以不加括号

    //////////////////////////////////////////
    //反编译
    //scalac Person.scala
    //javap -private Person
    //////////////////////////////////////////

    //getter和setter
    //age=就是getter方法，age_=就是set方法
    class Person {
      private var privateAge=0
      def age=privateAge
      def age_=(newValue: Int): Unit = {
        if(newValue>privateAge) privateAge=newValue; //不能再变年轻
      }
    }
    var Fred=new Person
    Fred.age=34
    Fred.age=21 //设置为21也没用
    println("Fred`s age:"+Fred.age)

    //如果要要get属性，通过private定义好，def一个方法操作该该值，然后再def一个方法取出该数值，略
    //scala可以访问同一类不同对象的私有字段，略

    class PersonNew {
      /*不是import scala.reflect.BeanProperty
  而是import scala.beans.BeanProperty*/
      /*将scala字段标注为@BeanProperty时，会自动生成getFoo,setFoo*/
      @BeanProperty var name: String = "12"
    }

    var p=new PersonNew
    p.setName("evoup") //set方法是自动生成的，直接调用就可以了
    println("my name:"+p.getName) //get方法同上

    p.name="akata"  //可见_=默认set方法也被生成了
    println("my nickname:"+p.name) //可见=默认get方法也被生成了
  }
  //构造函数，主构造函数就是this()，它可以写在class Class（param :Type）这种方式来定义

  //嵌套类略
}
