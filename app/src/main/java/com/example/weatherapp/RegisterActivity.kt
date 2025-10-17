package com.example.weatherapp

import android.app.Activity
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapp.ui.theme.WeatherAppTheme

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RegisterPage(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPage(modifier: Modifier = Modifier) {
    var username by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confirmPassword by rememberSaveable { mutableStateOf("") }
    val activity = LocalContext.current as Activity

    // modifier.padding(0.dp)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val defaultSpacing = 16.dp
        val fieldSpacing = 8.dp
        OutlinedTextField(
            value = username,
            label = { Text(text = "Digite seu nome de usuário") },
            modifier = Modifier.fillMaxWidth(fraction = .9f),
            onValueChange = { username = it }
        )
        Spacer(modifier = Modifier.size(fieldSpacing))
        OutlinedTextField(
            value = email,
            label = { Text(text = "Digite seu email") },
            modifier = Modifier.fillMaxWidth(fraction = .9f),
            onValueChange = { email = it }
        )
        Spacer(modifier = Modifier.size(fieldSpacing))
        OutlinedTextField(
            value = password,
            label = { Text(text = "Digite sua senha") },
            modifier = Modifier.fillMaxWidth(fraction = .9f),
            onValueChange = { password = it },
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.size(fieldSpacing))
        OutlinedTextField(
            value = confirmPassword,
            label = { Text(text = "Insira mais uma vez") },
            modifier = Modifier.fillMaxWidth(fraction = .9f),
            onValueChange = { confirmPassword = it },
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.size(defaultSpacing))
        Row(
            modifier = Modifier.fillMaxWidth(fraction = .9f),
            horizontalArrangement = Arrangement.SpaceEvenly)
        {
            Button(
                onClick = {
                    email = ""; password = "" }
            ) {
                Text("Limpar")
            }
            Button(
                onClick = {
                    activity.finish() }
            ) {
                Text("Sair")
            }
        }
        Button( onClick = {
            if(password.equals(confirmPassword)) {
                Toast.makeText(activity, "Registro confirmado!", Toast.LENGTH_LONG).show()
                activity.finish()
            } else {
                Toast.makeText(activity, "As senhas não são iguais! Insira novamente.", Toast.LENGTH_LONG).show()
            }
        },
            enabled = email.isNotEmpty() && password.isNotEmpty() && username.isNotEmpty()
        ) {
            Text("Registrar")
        }
    }
}