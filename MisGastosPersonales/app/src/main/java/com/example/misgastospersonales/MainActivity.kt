// FT
// punto de inicio de la app
//
package com.example.misgastospersonales

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.misgastospersonales.data.AppDatabase
import com.example.misgastospersonales.data.GastoRepository
import com.example.misgastospersonales.data.SettingsRepository
import com.example.misgastospersonales.ui.MainScreen
import com.example.misgastospersonales.ui.screens.SettingsScreen
import com.example.misgastospersonales.ui.theme.MisGastosPersonalesTheme
import com.example.misgastospersonales.viewmodel.GastosViewModel
import com.example.misgastospersonales.viewmodel.SettingsViewModel
import com.example.misgastospersonales.viewmodel.SettingsViewModelFactory
import kotlin.getValue

class MainActivity : ComponentActivity() {
    //inicializa el viewmodel usando kotlin
    private val database by lazy { AppDatabase.obtenerBaseDatos(applicationContext)}
    private val gastoRepository by lazy { GastoRepository(database.gastoDao())}
    private val gastosViewModel: GastosViewModel by viewModels()
    private val settingsViewModel: SettingsViewModel by viewModels {
        SettingsViewModelFactory(SettingsRepository(applicationContext),gastoRepository)}

    // conecta el viewModel con el mainActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // le pasa el ViewModel a la pantalla

        setContent {
            val mostrarConfiguracion = rememberSaveable {mutableStateOf(false)}
            val isDarkTheme by settingsViewModel.isDarkTheme.collectAsState(initial = false)
            val isConfigured by settingsViewModel.isConfigured.collectAsState(initial = false)

            MisGastosPersonalesTheme(darkTheme = isDarkTheme) {
                if (isConfigured && !mostrarConfiguracion.value) {
                    MainScreen(
                        viewModel = gastosViewModel,
                        settingsViewModel = settingsViewModel,
                        onOpenSettings = {mostrarConfiguracion.value = true
                        }
                    )
                } else {
                    SettingsScreen(
                        viewModel = settingsViewModel,
                        OnSaveSuccess = { settingsViewModel.saveIsConfigured(true)
                        mostrarConfiguracion.value = false}
                    )
                }
            }
        }
    }
}

