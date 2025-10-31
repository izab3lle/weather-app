package com.example.weatherapp

import android.app.Activity

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.ui.theme.DataField
import com.example.weatherapp.ui.theme.LoginHeading
import com.example.weatherapp.ui.theme.PasswordField
import com.example.weatherapp.ui.theme.WeatherAppTheme


class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginPage(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPage(modifier: Modifier = Modifier) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val activity = LocalActivity.current as Activity

    Column(
        modifier = modifier.padding(16.dp).fillMaxSize().fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val defaultSpacing = 20.dp
        val fieldSpacing = 8.dp

        LoginHeading(modifier)
        Spacer(modifier = Modifier.height(defaultSpacing))

        DataField(email, "Digite seu email") { email = it }
        Spacer(modifier = Modifier.size(fieldSpacing))

        PasswordField(password, "Digite sua senha") { password = it }
        Spacer(modifier = Modifier.size(defaultSpacing))

            Button(
                modifier = Modifier.fillMaxWidth(.9f),
                shape = RoundedCornerShape(9.dp),
                onClick = {
                    Toast.makeText(activity, "Login OK!", Toast.LENGTH_LONG).show()
                    activity.startActivity(
                        Intent(activity, MainActivity::class.java).setFlags(
                            FLAG_ACTIVITY_SINGLE_TOP
                        )
                    )},
                enabled = email.isNotEmpty() && password.isNotEmpty()
            ) {
                Text("Login")
            }


        // Botões "Login" e "Limpar"
        Row(
            modifier = Modifier.fillMaxWidth(fraction = .9f),
            horizontalArrangement = Arrangement.SpaceEvenly)
        {
            FilledTonalButton(
                modifier = Modifier.fillMaxWidth(.5f)
                            .padding(end = 10.dp),
                shape = RoundedCornerShape(9.dp),
                onClick = {
                    activity.startActivity(Intent(activity, RegisterActivity::class.java))
                }
            ) {
                Text("Registrar-se")
            }

            FilledTonalButton(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(9.dp),
                onClick = { email = ""; password = "" }
            ) {
                Text("Limpar")
            }
        }

    }
}