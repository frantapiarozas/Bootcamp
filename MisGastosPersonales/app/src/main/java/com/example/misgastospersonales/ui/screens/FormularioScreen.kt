// FT
// formulario ingreso de datos
//

package com.example.misgastospersonales.ui.screens
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.misgastospersonales.viewmodel.GastosViewModel

class FormularioScreen {
}


@Composable
fun FormularioScreen(viewModel: GastosViewModel) {
    var descripcion by remember { mutableStateOf("") }
    var montoText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = descripcion,
            onValueChange = { descripcion = it },
            label = { Text("Descripción del gasto") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = montoText,
            onValueChange = { montoText = it },
            label = { Text("Monto") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val monto = montoText.toDoubleOrNull() ?: 0.0
                if (descripcion.isNotBlank() && monto > 0) {
                    viewModel.agregarGasto(descripcion, monto)
                    descripcion = ""
                    montoText = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar Gasto")
        }
    }
}