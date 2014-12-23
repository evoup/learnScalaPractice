package com.evoup

/**
 * Created by yinjia on 2014/12/16.
 */
//class SavingsAccount {
  class SavingsAccount extends Account with ConsoleLogger2 {
  def withdraw(amount: Double): Unit = {
     var  balance=3000.00
    if (amount > balance) {
      log("insufficient funds")
    }else {
      balance-=amount
      log("remain:"+amount)
    }
  }
}

class Account{

}

class SavingsAccount2 extends Account with Logged {
  def withdraw(amount: Double): Unit = {
    var blance=3000.00
    if (amount>blance) {
      log("Insufficient funds")
    } else {
      blance-=amount
      log("remain:"+blance)
    }
  }
}

