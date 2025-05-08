package com.alpha.kotlinbasictoadvancedcourse.activities
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alpha.kotlinbasictoadvancedcourse.basic_ui_designs.LazyColumnLists
import com.alpha.kotlinbasictoadvancedcourse.basic_ui_designs.LoginScreen
import com.alpha.kotlinbasictoadvancedcourse.basic_ui_designs.SignUpScreen
import com.alpha.kotlinbasictoadvancedcourse.basic_ui_designs.SimpleUI
import com.alpha.kotlinbasictoadvancedcourse.mvvm.CounterViewModel
import com.alpha.kotlinbasictoadvancedcourse.mvvm.TheCounterApp
import com.alpha.kotlinbasictoadvancedcourse.navigation.FirstScreen
import com.alpha.kotlinbasictoadvancedcourse.navigation.SecondScreen
import com.alpha.kotlinbasictoadvancedcourse.retrofit.RecipeApp
import com.alpha.kotlinbasictoadvancedcourse.shopping.Shopping
import com.alpha.kotlinbasictoadvancedcourse.ui.theme.KotlinBasicToAdvancedCourseTheme
import com.alpha.kotlinbasictoadvancedcourse.unit_converter.UnitConverter

class Navigation : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinBasicToAdvancedCourseTheme {
                Surface( // 🛠️ Wrap UI inside Surface
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp(){
    val navController = rememberNavController()
    NavHost(navController = navController,startDestination = "firstscreen"){
        composable("firstscreen"){
            FirstScreen {
                navController.navigate("secondscreen")
            }
        }
        composable(route = "secondscreen"){
            SecondScreen {
                navController.navigate("firstscreen")
            }
        }
    }
}
