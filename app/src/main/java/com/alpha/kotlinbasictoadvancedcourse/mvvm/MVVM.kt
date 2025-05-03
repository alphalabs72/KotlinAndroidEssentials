package com.alpha.kotlinbasictoadvancedcourse.mvvm

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alpha.kotlinbasictoadvancedcourse.mvvm.CounterViewModel

@Composable
fun TheCounterApp(viewModel: CounterViewModel){
    val count = remember { mutableStateOf(0) }

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Count: ${viewModel.count.value}",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold)
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Row {
            Button(onClick = {
                viewModel.increment()
            }) {
                Text("Increment")
            }
            Button(onClick = {
                viewModel.decrement()
            }) {
                Text("Decrement")
            }
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TheCounterAppPreview(){
    val dummyViewModel = object : CounterViewModel() {}
    TheCounterApp(viewModel = dummyViewModel)
}