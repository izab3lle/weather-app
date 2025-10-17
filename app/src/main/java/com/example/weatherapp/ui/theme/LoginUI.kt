package com.example.weatherapp.ui.theme

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.weatherapp.MainActivity
import com.example.weatherapp.RegisterActivity

@Composable
fun LoginButton(email: String, password: String, activity: Context) {
    Button(
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
}

@Composable
fun RegisterButton(activity: Context) {
    Button(
        modifier = Modifier.fillMaxWidth(.9f),
        onClick = {
        activity.startActivity(Intent(activity, RegisterActivity::class.java))
    }) {
        Text("Registrar-se")
    }
}
