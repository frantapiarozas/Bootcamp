//FT
//pantalla de configuraciones
//
package com.example.misgastospersonales.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.misgastospersonales.viewmodel.SettingsViewModel
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

@Composable
fun SettingsScreen(viewModel: SettingsViewModel, OnSaveSuccess: () -> Unit
) {
    //contexto para Toast
    val context = LocalContext.current

    val isDarkTheme by viewModel.isDarkTheme.collectAsState()
    val userName by viewModel.userName.collectAsState()
    val dailyLimit by viewModel.dailyLimit.collectAsState()

    var nameInput by remember(userName) { mutableStateOf(userName) }
    var limitInput by remember(dailyLimit) { mutableStateOf(dailyLimit.toString()) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                //espacio superior para bajar contenido
                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Configuración inicial",
                    style = MaterialTheme.typography.headlineMedium
                )

                Spacer(modifier = Modifier.height(16.dp))

                //campos del formulario
                OutlinedTextField(
                    value = nameInput,
                    onValueChange = { nameInput = it },
                    label = { Text("Tu Nombre") },
                    modifier = Modifier.fillMaxWidth()
                )
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
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Tema Oscuro", modifier = Modifier.weight(1f))
                    Switch(
                        checked = isDarkTheme,
                        onCheckedChange = { viewModel.updateTheme(it) }
                    )
                }
                //empuja botones hacia abajo
                Spacer(modifier = Modifier.weight(1f))
                //boton guardar
                Button(
                    onClick = {
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
                        nameInput = ""
                        limitInput = ""
                        Toast.makeText(
                            context,
                            "Configuracion y datos borrados correctamente",
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red), // Color de advertencia opcional
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Borrar todo y reiniciar configuración")
                }
                // margen inferior
                Spacer(modifier = Modifier.height(48.dp))
            }
        }
    }
}

