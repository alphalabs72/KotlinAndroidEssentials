package com.alpha.kotlinbasictoadvancedcourse

fun main(){
    val alphaBankAccount = BankAccount("Alpha",3200.0)

    alphaBankAccount.deposit(800.0)
    alphaBankAccount.withdraw(100.0)
    alphaBankAccount.displayTransactionHistory()

    println("${alphaBankAccount.accountHolder}'s balance is ${alphaBankAccount.balance}")
}