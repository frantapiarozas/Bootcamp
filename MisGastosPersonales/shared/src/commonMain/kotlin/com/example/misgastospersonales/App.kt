//
//  entrada principal del usuario en mpk
//
package com.example.misgastospersonales

import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.misgastospersonales.data.GastoRepository
import com.example.misgastospersonales.data.SettingsRepository
import com.example.misgastospersonales.ui.MainScreen
import com.example.misgastospersonales.ui.screens.SettingsScreen
import com.example.misgastospersonales.ui.theme.MisGastosPersonalesTheme
import com.example.misgastospersonales.viewmodel.GastosViewmodel
import com.example.misgastospersonales.viewmodel.SettingsViewModel
import com.example.misgastospersonales.data.AppDatabase

@Composable
fun App(database: AppDataBase) {
    val gastoRepository = remember { GastoRepository(database.gastoDao()) }
    val settingsRepository = remember { SettingsRepository() }
    val gastosViewModel = remember { GastosViewmodel(gastoRepository) }
    val settingsViewModel = remember { SettingsViewModel(settingsRepository)}

    // Observar los estados de configuración y tema
    val isDarkTheme by settingsViewModel.isDarkTheme.collectAsState(initial = false)
    val isConfigured by settingsViewModel.isConfigured.collectAsState(initial = false)

    // Estado local para abrir manualmente la configuración desde MainScreen
    var mostrarConfiguracion by rememberSaveable { mutableStateOf(false) }

    // Aplicar el tema (dark/light)
    MisGastosPersonalesTheme(darkTheme = isDarkTheme) {
        if (isConfigured && !mostrarConfiguracion) {
            MainScreen(
                viewModel = gastosViewModel,
                settingsViewModel = settingsViewModel,
                onOpenSettings = { mostrarConfiguracion = true }
            )
        } else {
            SettingsScreen(
                viewModel = settingsViewModel,
                OnSaveSuccess = {
                    // Guardar que ya se configuró y volver a la pantalla principal
                    settingsViewModel.saveIsConfigured(true)
                    mostrarConfiguracion = false
                }
            )
        }
    }
}