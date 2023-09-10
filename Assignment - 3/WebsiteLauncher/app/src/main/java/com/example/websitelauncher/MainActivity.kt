package com.example.websitelauncher

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.websitelauncher.ui.theme.WebsiteLauncherTheme

var url: String = "https://www.amazon.in/"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WebsiteLauncherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Login()
                }
            }
        }
    }
}

@Composable
fun Login() {
    val context = LocalContext.current
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFFF99FF))) {
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Website Launcher", fontFamily = FontFamily.Cursive, fontSize = 48.sp, modifier = Modifier.padding(32.dp), color = Color(0xFF2345FF), fontWeight = FontWeight.Bold)
            Image(painter = painterResource(id = R.drawable.profile), contentDescription = "User Profile", modifier = Modifier.padding(16.dp).size(150.dp))
            input()
        }
        selection()
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(onClick = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                context.startActivity(intent)
                /*if(intent.resolveActivity(context.packageManager) != null) {
                    context.startActivity(intent)
                } else {
                    Toast.makeText(context, "No Web Browser is Available", Toast.LENGTH_LONG).show()
                }*/
            }, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF2345FF))) {
                Text(text = "Launch")
            }
        }
    }
}

@Composable
fun selection() {
    var selectedOption by remember { mutableStateOf("Amazon") }
    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Text(text = "Select an option:")
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            RadioButton(selected = selectedOption=="Amazon", onClick = { selectedOption = "Amazon"; url = "https://www.amazon.in/" })
            Text(text = "Amazon", modifier = Modifier.padding(vertical = 12.dp))
        }
        Row {
        RadioButton(selected = selectedOption=="Flipkart", onClick = { selectedOption = "Flipkart"; url = "https://www.flipkart.com/" })
        Text(text = "Flipkart", modifier = Modifier.padding(vertical = 12.dp))
        }
        Row {
            RadioButton(selected = selectedOption=="Myntra", onClick = { selectedOption = "Myntra"; url = "https://www.myntra.com/" })
            Text(text = "Myntra", modifier = Modifier.padding(vertical = 12.dp))
        }
        Row {
        RadioButton(selected = selectedOption=="Ajio", onClick = { selectedOption = "Ajio"; url = "https://www.ajio.com/" })
        Text(text = "Ajio", modifier = Modifier.padding(vertical = 12.dp))
        }
    }
}

@Composable
fun input() {
    var username by remember{mutableStateOf("")}
    var password by remember{mutableStateOf("")}
    OutlinedTextField(value = username, onValueChange = {it -> username = it}, label = { Text(text = "Username") }, colors = TextFieldDefaults. outlinedTextFieldColors(focusedBorderColor = Color(0xFF2345FF)))
    OutlinedTextField(value = password, onValueChange = {it -> password = it}, label = { Text(text = "Password") }, colors = TextFieldDefaults. outlinedTextFieldColors(focusedBorderColor = Color(0xFF2345FF)), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done), keyboardActions = KeyboardActions(onDone = {}), visualTransformation = PasswordVisualTransformation())
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WebsiteLauncherTheme {
        Login()
    }
}