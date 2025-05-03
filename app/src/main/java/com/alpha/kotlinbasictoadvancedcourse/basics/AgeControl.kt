package com.alpha.kotlinbasictoadvancedcourse.basics

fun main(){
    println("Enter your age:")
    var age = 0
    val enteredAge = readln()
    age = enteredAge.toInt()

    if (age in 18..39){
        println("You can enter into the club")
    }else if (age >= 40){
        println("You're too old!")
    }else{
        println("You're too young! Can't enter into the club")
    }
}