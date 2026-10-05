package com.example.misgastospersonales.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.misgastospersonales.data.GastoRepository
import com.example.misgastospersonales.data.SettingsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SettingsViewModel(private val repository: SettingsRepository,
    private val gastoRepository: GastoRepository) : ViewModel () {

    val isConfigured: StateFlow<Boolean> = repository.isConfiguredFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = false
    )
    val isDarkTheme: StateFlow<Boolean> = repository.themeFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = false
    )
    val userName: StateFlow<String> = repository.userNameFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = "Usuario"
    )
    val dailyLimit: StateFlow<Int> = repository.dailyLimitFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = 0
    )
    // funciones paraa actualizar datos

    //guarda el limite mensual
    fun updateLimit(limit: Int) {
        viewModelScope.launch { repository.saveLimit(limit) }
    }

    //guardar el nombre de usuario
    fun updateName(name: String) {
        viewModelScope.launch { repository.saveName(name) }
    }

    //cambiar el tema
    fun updateTheme(isDark: Boolean) {
        viewModelScope.launch { repository.saveTheme(isDark) }
    }

    // guarda la configuracion
    fun saveIsConfigured(isConfigured: Boolean) {
        viewModelScope.launch { repository.saveIsConfigured(isConfigured) }
    }
    fun resetAllData() {
        viewModelScope.launch {
            // 1. Borra los gastos de la base de datos
            gastoRepository.deleteAllGastos()

            // 2. Resetea la configuración del usuario
            repository.saveIsConfigured(false)
        }
    }
}

class SettingsViewModelFactory(
    private val repository: SettingsRepository,
    private val gastoRepository: GastoRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T{
        if (modelClass.isAssignableFrom(SettingsViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return SettingsViewModel(repository, gastoRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

