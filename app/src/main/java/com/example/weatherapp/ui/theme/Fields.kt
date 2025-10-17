package com.example.weatherapp.ui.theme

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation

@Composable
fun DataField(value: String, text: String, lambda: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        label = { Text(text) },
        modifier = Modifier.fillMaxWidth(fraction = .9f),
        onValueChange = lambda
    )
}

@Composable
fun PasswordField(value: String, text: String, lambda: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        label = { Text(text) },
        modifier = Modifier.fillMaxWidth(fraction = .9f),
        onValueChange = lambda,
        visualTransformation = PasswordVisualTransformation()
    )
}
