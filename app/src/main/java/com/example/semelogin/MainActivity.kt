package com.example.semelogin

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.semelogin.ui.theme.SemeLoginTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SemeLoginTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar ={ TopAppBar(backgroundColor = Color.Blue,
                    title = { Text(text = "Seme Login Screen",color=Color.White)}) } ) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                    ) {
                        LoginScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun LoginScreen() {
    var context= LocalContext.current
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var msg by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        OutlinedTextField(value = username, 
            onValueChange = {username=it},
            placeholder = { Text(text = "Enter username")},
            label={ Text(text = "Username")},
            shape = RoundedCornerShape(percent = 20),
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = password,
            onValueChange = {password=it},
            placeholder = { Text(text = "Enter password")},
            label={ Text(text = "Password")},
            visualTransformation =  PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            shape = RoundedCornerShape(percent = 20),
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedButton(onClick = {
           if(username.isNotEmpty() && password.isNotEmpty())
           {
               if(username.equals("Semetvc") && password.equals("1234"))
               {
                   msg="Successfully logged in"
               }
               else
               {
                   msg="Wrong username or password"
               }
           }
            else
           {
               msg="Please enter all the information"
           }

            Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()
        }) {
           Text(text = "Login")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SemeLoginTheme {
        LoginScreen()
    }
}