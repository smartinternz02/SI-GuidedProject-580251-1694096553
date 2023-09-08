package com.example.login


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login.ui.theme.LoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    login()
                }
            }
        }
    }
}

@Composable
fun login() {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("Login Page", fontWeight = FontWeight.Bold, fontSize = 24.sp)
        Spacer(modifier = Modifier.padding(vertical = 15.dp))
        input()
        Spacer(modifier = Modifier.padding(vertical = 30.dp))
        Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color(0xFF00FFFF))) {
            Text(text = "Submit", color = Color(0xFFFFFFFF))
        }
    }
}

@Composable
fun input() {
    var name by remember { mutableStateOf("") }
    TextField(value = name, onValueChange = {it -> name = it}, label = {Text("Enter Username")})
    Spacer(modifier = Modifier.padding(5.dp))
    var pass by remember { mutableStateOf("") }
    TextField(value = pass, onValueChange = {it -> pass = it}, label = {Text("Enter Password")})
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginTheme {
        login()
    }
}
