// FT
// interfaz de usuario principal

package com.example.misgastospersonales.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.misgastospersonales.ui.screens.FormularioScreen
import com.example.misgastospersonales.ui.screens.HistorialScreen
import com.example.misgastospersonales.viewmodel.GastosViewModel
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun MainScreen(viewModel: GastosViewModel) {
    var pantallaActual by remember { mutableStateOf(Pantalla.FORMULARIO) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (pantallaActual == Pantalla.FORMULARIO) "Nuevo Gasto" else "Histórico") }
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = pantallaActual == Pantalla.FORMULARIO,
                    onClick = { pantallaActual = Pantalla.FORMULARIO },
                    label = { Text("Agregar") },
                    icon = {}
                )
                NavigationBarItem(
                    selected = pantallaActual == Pantalla.HISTORIAL,
                    onClick = { pantallaActual = Pantalla.HISTORIAL },
                    label = { Text("Histórico") },
                    icon = {}
                )
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            when (pantallaActual) {
                Pantalla.FORMULARIO -> FormularioScreen(viewModel)
                Pantalla.HISTORIAL -> HistorialScreen(viewModel)
            }
        }
    }
}