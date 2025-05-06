package com.alpha.kotlinbasictoadvancedcourse.retrofit

// ApiService.kt
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("categories.php")
    suspend fun getCategories(): CategoriesResponse
}

// Create Retrofit instance
private val retrofit = Retrofit.Builder()
    .baseUrl("https://www.themealdb.com/api/json/v1/1/") // ✅ base URL only
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val recipeService: ApiService = retrofit.create(ApiService::class.java)
