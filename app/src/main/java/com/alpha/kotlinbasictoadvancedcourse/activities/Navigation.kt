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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alpha.kotlinbasictoadvancedcourse.navigation.FirstScreen
import com.alpha.kotlinbasictoadvancedcourse.navigation.SecondScreen
import com.alpha.kotlinbasictoadvancedcourse.ui.theme.KotlinBasicToAdvancedCourseTheme

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
            FirstScreen {name ->
                navController.navigate("secondscreen/ $name")
            }
        }
        composable(route = "secondscreen/{name}"){
            val name = it.arguments?.getString("name") ?: "no name"
            SecondScreen(name) {
                navController.navigate("firstscreen")
            }
        }
    }
}
