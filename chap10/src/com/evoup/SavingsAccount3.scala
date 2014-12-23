package com.evoup

/**
 * Created by yinjia on 2014/12/17.
 */
class SavingsAccount3 extends Account with Logger2{
  def withdraw(amount:Double): Unit ={
    var balance=3000.00
    if (amount>balance) severe("Insufficient funds")
    else {
      balance-=amount
      severe("remain:"+balance)
    }
  }
  override def log(msg:String) {println(msg);}
}