// FT
// formulario ingreso de datos
//

package com.example.misgastospersonales.ui.screens
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.misgastospersonales.viewmodel.GastosViewModel
import kotlinx.coroutines.launch

@Composable
fun FormularioScreen(
    viewModel: GastosViewModel,
    modifier: Modifier = Modifier
) {
   val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScoupe = rememberCoroutineScope()

    //estados para controlar alerta del limite
    var mostrarAdvertencia by remember { mutableStateOf(false) }
    var limiteConfigurado by remember { mutableStateOf(0) }
    var totalConNuevoGasto by remember { mutableStateOf(0) }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Nuevo gasto",
                style = MaterialTheme.typography.headlineMedium
            )
            //descripcion y monto conectado al viewmodel
            OutlinedTextField(
                value = viewModel.descripcion,
                onValueChange = { viewModel.onDescripcionChanged(it) },
                label = { Text("Descripción del gasto") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = viewModel.montoInput,
                onValueChange = { viewModel.onMontoChanged(it) },
                label = { Text("Monto") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )
            //boton se desabilita si no hay text
            val esFormularioValido =
                viewModel.descripcion.isNotBlank() && viewModel.montoInput.isNotBlank()

            Button(
                onClick = {
                    val monto = viewModel.montoInput.toIntOrNull() ?: 0
                    viewModel.agregarGasto(
                        descripcion = viewModel.descripcion,
                        monto = monto,
                        onExceedsLimit = { limite, totalProyectado ->
                            limiteConfigurado = limite
                            totalConNuevoGasto = totalProyectado
                            mostrarAdvertencia = true
                        },
                        onSuccess = {
                            viewModel.limpiarFormulario()
                            coroutineScoupe.launch {
                                snackbarHostState.showSnackbar("Gasto guardado correctamente")
                            }
                        }
                    )
                },
                enabled = esFormularioValido,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Guardar Gasto")
            }
        }
    }


    // Diálogo emergente de advertencia si se sobrepasa el límite diario
    if (mostrarAdvertencia) {
        AlertDialog(
            onDismissRequest = { mostrarAdvertencia = false },
            title = { Text(" ¡Atención! Límite Superado") },
            text = {
                Text("Con este gasto sumarás $$totalConNuevoGasto y superarás tu " +
                        "límite diario de $$limiteConfigurado.")
            },
            confirmButton = {
                TextButton(onClick = { mostrarAdvertencia = false }) {
                    Text("Aceptar")
                }
            })
    }
}
