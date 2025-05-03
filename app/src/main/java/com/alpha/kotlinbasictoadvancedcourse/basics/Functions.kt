package com.alpha.kotlinbasictoadvancedcourse.basics

fun main(){
    askDetails()
}
fun askDetails(){
    println("Enter your name:")
    val name = readln()
    println("How many pieces of sugar do you want?")
    val  sugarPieces = readln()
    //call function with parameter values
    makeCoffee(sugarPieces.toInt(), name)
}

//defined function
fun makeCoffee(sugarCount: Int, name: String){
    when (sugarCount) {
        0 -> {
            println("Coffee with no sugar for $name")
        }
        else -> println("Coffee with $sugarCount spoons of sugar for $name")
    }
    askNumbers()
}
fun askNumbers(){
    println("Enter the first number:")
    val firstNumber = readln()
    println("Enter the second number:")
    val secondNumber = readln()
    val finalResult = calculateNumber(firstNumber.toInt(),secondNumber.toInt())
    println("The result of adding numbers: $finalResult")
}
fun calculateNumber(firstN: Int, secondN: Int): Int{
    val result = firstN + secondN
    return result
}