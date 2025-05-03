package com.alpha.kotlinbasictoadvancedcourse.basics

fun main(){
    //immutable lists
    val shoppingList = listOf("RAM", "Processor", "Graphic Card RTX 3060", "SSD")

    //mutable lists
    val shoppingListItems = mutableListOf("RAM", "Processor", "Graphic Card RTX 3060", "SSD")
    shoppingListItems.add("Cooling System")
    shoppingListItems.remove("Graphic Card RTX 3060")
    shoppingListItems.add("Graphic Card RTX 4090")

    shoppingListItems.removeAt(1)
    shoppingListItems.add(1,"M2 Chip")

    /*
    shoppingListItems[3] = "HDD"
    shoppingListItems.set(3,"HDD 1TB")
     */

    println(shoppingListItems)
    println()

    val hasMChip = shoppingListItems.contains("M2 Chip")
    if (hasMChip){
        println("M Chip in the lists")
    }else println("No M chip in the lists")

    /*
    for (item in shoppingListItems){
        println(item)
        if (item == "SSD"){
            break
        }
    }
     */
    for (item in 0 until shoppingListItems.size){
        println("${shoppingListItems[item]} is in $item")
    }

}