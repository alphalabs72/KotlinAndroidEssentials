package com.alpha.kotlinbasictoadvancedcourse.basic_ui_designs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SimpleUI() {
    var name by remember { mutableStateOf("") }
    var greeting by remember { mutableStateOf("") }
    var selectedOption by remember { mutableStateOf("Male") }
    var isChecked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Avatar (replace with real image later)
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color.Gray, CircleShape)
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text("John Doe", fontWeight = FontWeight.Bold)
                    Text("Android Developer", fontSize = 12.sp, color = Color.Gray)
                }

                Button(onClick = { /* Handle follow */ }) {
                    Text("Follow")
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Image(
            painter = painterResource(id = com.alpha.kotlinbasictoadvancedcourse.R.drawable.jetpack),
            contentDescription = "Logo",
            modifier = Modifier.size(64.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Enter your name") },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            greeting = "Hello, $name!"
        }) {
            Text("Greet Me")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (greeting.isNotEmpty()) {
            Text(text = greeting, fontSize = 20.sp)
        }

        Column(modifier = Modifier.padding(16.dp)) {
            // Male option
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = selectedOption == "Male",
                    onClick = { selectedOption = "Male" }
                )
                Text("Male", modifier = Modifier.padding(start = 8.dp))
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Female option
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = selectedOption == "Female",
                    onClick = { selectedOption = "Female" }
                )
                Text("Female", modifier = Modifier.padding(start = 8.dp))
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Show selected option
            Text("Selected: $selectedOption")

            Spacer(modifier = Modifier.height(16.dp))

            // Checkbox with a label
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = isChecked,
                    onCheckedChange = { isChecked = it }
                )
                Text("Accept Terms and Conditions", modifier = Modifier.padding(start = 8.dp))
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Display the checkbox state
            Text("Checked: $isChecked")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SimpleInputScreenPreview(){
    SimpleUI()
}
