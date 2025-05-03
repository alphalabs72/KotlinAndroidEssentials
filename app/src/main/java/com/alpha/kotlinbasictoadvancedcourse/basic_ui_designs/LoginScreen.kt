package com.alpha.kotlinbasictoadvancedcourse.basic_ui_designs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alpha.kotlinbasictoadvancedcourse.R

@Composable
fun LoginScreen() {
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }

    @Composable
    fun getColorFromResources(colorId: Int): Color {
        val context = LocalContext.current
        return Color(context.getColor(colorId))
    }
    @Composable
    fun CustomRectangularButton(
        text: String,
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        backgroundColor: Color = getColorFromResources(R.color.teal_200),
        textColor: Color = Color.White
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(48.dp) // Adjust the height
                .background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(8.dp) // Optional: to give rounded corners
                )
                .clickable { onClick() }
                .padding(horizontal = 16.dp), // Adjust the horizontal padding
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                color = textColor,
                style = MaterialTheme.typography.labelLarge
            )
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // App logo
        Image(
            painter = painterResource(id = R.drawable.jetpack),
            contentDescription = "Logo",
            modifier = Modifier.size(64.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Sign-in text
        Text(
            text = "Sign in your account",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Email TextField
        OutlinedTextField(
            value = emailState.value,
            onValueChange = { emailState.value = it },
            label = { Text("Email") },
            placeholder = { Text("ex: jon.smith@email.com") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Password TextField
        OutlinedTextField(
            value = passwordState.value,
            onValueChange = { passwordState.value = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Custom Rectangular Sign-in button
        CustomRectangularButton(
            text = "Sign In",
            onClick = { /* Handle sign-in */ },
            backgroundColor = getColorFromResources(R.color.teal_700) // Use a color of your choice
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Social login buttons
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            SocialLoginButton(icon = R.drawable.jetpack)
            Spacer(modifier = Modifier.width(16.dp))
            SocialLoginButton(icon = R.drawable.jetpack)
            Spacer(modifier = Modifier.width(16.dp))
            SocialLoginButton(icon = R.drawable.jetpack)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Sign-up text
        TextButton(onClick = { /* Navigate to sign up */ }) {
            Text(
                text = "Don't have an account? Sign Up",
                style = MaterialTheme.typography.labelMedium,
                color = getColorFromResources(R.color.teal_200)
            )
        }
    }
}

@Composable
fun SocialLoginButton(icon: Int) {
    IconButton(onClick = { /* Handle social login */ }) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = "Social Login",
            modifier = Modifier.size(48.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview(){
    LoginScreen()
}