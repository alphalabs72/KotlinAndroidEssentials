package com.alpha.kotlinbasictoadvancedcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.alpha.kotlinbasictoadvancedcourse.basic_ui_designs.LazyColumnLists
import com.alpha.kotlinbasictoadvancedcourse.basic_ui_designs.LoginScreen
import com.alpha.kotlinbasictoadvancedcourse.basic_ui_designs.SignUpScreen
import com.alpha.kotlinbasictoadvancedcourse.basic_ui_designs.SimpleUI
import com.alpha.kotlinbasictoadvancedcourse.mvvm.CounterViewModel
import com.alpha.kotlinbasictoadvancedcourse.mvvm.TheCounterApp
import com.alpha.kotlinbasictoadvancedcourse.retrofit.RecipeApp
import com.alpha.kotlinbasictoadvancedcourse.retrofit.RecipeScreen
import com.alpha.kotlinbasictoadvancedcourse.retrofit.Screen
import com.alpha.kotlinbasictoadvancedcourse.shopping.Shopping
import com.alpha.kotlinbasictoadvancedcourse.ui.theme.KotlinBasicToAdvancedCourseTheme
import com.alpha.kotlinbasictoadvancedcourse.unit_converter.UnitConverter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            // below line for MVVM
            val viewModel: CounterViewModel = viewModel()

            //below line for RecipeApp
            val navController = rememberNavController()

            KotlinBasicToAdvancedCourseTheme {
                Surface( // 🛠️ Wrap UI inside Surface
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // uncomment and run for each class

//                    SimpleUI()
//                    LazyColumnLists()
//                    LoginScreen()
//                    SignUpScreen()
//                    UnitConverter()
//                    Shopping()
//                    TheCounterApp(viewModel = viewModel)

                    RecipeApp(navController = navController)
                }
            }
        }
    }
}
