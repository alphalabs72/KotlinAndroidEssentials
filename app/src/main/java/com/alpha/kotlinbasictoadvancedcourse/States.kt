package com.alpha.kotlinbasictoadvancedcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alpha.kotlinbasictoadvancedcourse.ui.theme.KotlinBasicToAdvancedCourseTheme
import kotlin.random.Random

class States : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinBasicToAdvancedCourseTheme {
                Surface( // 🛠️ Wrap UI inside Surface
                    modifier = Modifier.Companion.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CaptainGame()
                }
            }
        }
    }

    @Composable
    fun CaptainGame(){
        val treasuresFound = remember { mutableIntStateOf(0) }
        val direction = remember { mutableStateOf("North") }
        val stormOrTreasure = remember { mutableStateOf("") }

        Column(
            modifier = Modifier.Companion.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Companion.CenterHorizontally
        ) {
            Text(text = "Treasures Found: ${treasuresFound.intValue}")
            Text(text = "Current Direction: ${direction.value}")
            Text(text = stormOrTreasure.value)
            Spacer(modifier = Modifier.Companion.height(10.dp))
            Button(onClick = {
                direction.value = "East"
                if (Random.Default.nextBoolean()) {
                    treasuresFound.intValue += 1
                    stormOrTreasure.value = "Found treasure"
                } else stormOrTreasure.value = "Storm ahead!!"
            }) {
                Text("Sail East")
            }
            Spacer(modifier = Modifier.Companion.height(10.dp))
            Button(onClick = {
                direction.value = "West"
                if (Random.Default.nextBoolean()) {
                    treasuresFound.intValue += 1
                    stormOrTreasure.value = "Found treasure"
                } else stormOrTreasure.value = "Storm ahead!!"
            }) {
                Text("Sail West")
            }
            Spacer(modifier = Modifier.Companion.height(10.dp))
            Button(onClick = {
                direction.value = "South"
                if (Random.Default.nextBoolean()) {
                    treasuresFound.intValue += 1
                    stormOrTreasure.value = "Found treasure"
                } else stormOrTreasure.value = "Storm ahead!!"
            }) {
                Text("Sail South")
            }
            Spacer(modifier = Modifier.Companion.height(10.dp))
            Button(onClick = {
                direction.value = "North"
                if (Random.Default.nextBoolean()) {
                    treasuresFound.intValue += 1
                    stormOrTreasure.value = "Found treasure"
                } else stormOrTreasure.value = "Storm ahead!!"
            }) {
                Text("Sail North")
            }
        }

    }

    @Preview(showSystemUi = true, showBackground = true)
    @Composable
    fun CaptainGamePreview(){
        CaptainGame()
    }
}