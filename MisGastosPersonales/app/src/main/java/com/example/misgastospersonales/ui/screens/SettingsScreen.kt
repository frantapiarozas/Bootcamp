package com.example.misgastospersonales.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.misgastospersonales.viewmodel.SettingsViewModel

@Composable
fun SettingsScreen(viewModel: SettingsViewModel, OnSaveSuccess: () -> Unit) {
    val isDarkTheme by viewModel.isDarkTheme.collectAsState()
    val userName by viewModel.userName.collectAsState()
    val dailyLimit by viewModel.dailyLimit.collectAsState()

    var nameInput by remember(userName) { mutableStateOf(userName) }
    var limitInput by remember(dailyLimit) { mutableStateOf(dailyLimit.toString())}
    var isDark by remember {mutableStateOf(false)}


    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    )
    {
        Text(text = "Configuraciones inicial", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        // Nombre de usuario
        OutlinedTextField(
            value = nameInput,
            onValueChange = { nameInput = it },
            label = { Text("Tu Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Límite de gasto diario
        OutlinedTextField(
            value = limitInput,
            onValueChange = { limitInput = it },
            label = { Text("Límite de Gasto Diario") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        //cambiar tema claro/oscuro
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Tema Oscuro")
            Switch(
                checked = isDarkTheme,
                onCheckedChange = { viewModel.updateTheme(it) }
            )
        }

        Button(
            onClick = {
                val limit = limitInput.toIntOrNull() ?: 0
                viewModel.updateName(nameInput)
                viewModel.updateLimit(limitInput.toIntOrNull() ?: 0)
                viewModel.updateTheme(isDarkTheme)
                OnSaveSuccess()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar y continuar")
        }

        Button(
            onClick = {
                viewModel.resetAllData()
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red) // Color de advertencia opcional
        ) {
            Text(text = "Borrar todo y reiniciar configuración")
        }
    }
}



