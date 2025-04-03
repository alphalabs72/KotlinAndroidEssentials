package com.alpha.kotlinbasictoadvancedcourse

class Dog (val name: String,val breed: String) {
    init {
        bark(name)
    }
    private fun bark(name: String){
        println("$name says Woof Woof")
    }
}