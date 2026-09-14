// FT
// pantalla de historial
//
package com.example.creandoformulario.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.creandoformulario.viewmodel.FormularioViewmodel


@Composable
fun HistorialScreen(
    viewModel: FormularioViewmodel,
    onVolver: () -> Unit
) {
    val registros = viewModel.historialList

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)
    ) {
        Button(onClick = onVolver) {
            Text("Volver al Formulario")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Historial de registros",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(bottom = 80.dp)
        ) {
            items(registros) { registro ->
                ItemHistorial(nombre = registro.first, correo = registro.second)
            }
        }
    }
}

@Composable
fun ItemHistorial(nombre: String, correo: String) {
    Card (
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Nombre: $nombre", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Correo: $correo", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
