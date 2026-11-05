// FT
// historial gastos guardados
//
package com.example.misgastospersonales.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.misgastospersonales.viewmodel.GastosViewModel

@Composable
fun HistorialScreen(viewModel: GastosViewModel,
                    modifier:Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(viewModel.listaGastos.value) { gasto ->
            Card(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                ){
                    Text(
                        text = gasto.descripcion,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = "$${gasto.monto.toInt()}"
                    )
                }
            }
        }
    }
}
