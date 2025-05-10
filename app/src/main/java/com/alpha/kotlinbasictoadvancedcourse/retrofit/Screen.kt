package com.alpha.kotlinbasictoadvancedcourse.retrofit

sealed class Screen(val route: String){
    object RecipeScreen: Screen("reciprescreen")
    object DetailScreen: Screen("detailescreen")
}