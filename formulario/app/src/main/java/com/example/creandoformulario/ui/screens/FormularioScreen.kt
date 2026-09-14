// FT
// pantallas del formulario
//
package com.example.creandoformulario.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.creandoformulario.viewmodel.FormularioViewmodel

// class FormularioScreen

@Composable
fun FormularioScreen(
    viewModel: FormularioViewmodel,
    onNavegarHistorial:() -> Unit ) {
    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    val context = LocalContext.current

    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
             .imePadding()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        //1. titulo
        Text(
            text = "Formulario de registro",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 20.dp) //espacio con respecto a nombre
        )
        //2. campo nombre
        OutlinedTextField(
            value = viewModel.nombre,
            onValueChange = { viewModel.onNombreChange(it) },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        //3. campo correo
        OutlinedTextField(
            value = viewModel.correo,
            onValueChange = { viewModel.onCorreoChange(it) },
            label = { Text("Correo") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))

        //4. boton guardar
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    viewModel.guardar()
                    Toast.makeText(
                        context,
                        "Datos guardados en SQLite",
                        Toast.LENGTH_SHORT
                    ).show()
                    nombre = ""
                    correo = ""
                }
            ) {
                Text("guardar")
            }
            Button(
                onClick = { onNavegarHistorial() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Text("Ver Historial")
            }
        }
    }
}