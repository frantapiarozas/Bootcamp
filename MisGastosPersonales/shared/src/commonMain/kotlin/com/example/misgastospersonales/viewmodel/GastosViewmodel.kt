//FT
//viewmodel sobre los gastos en mpk
//
package com.example.misgastospersonales.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.misgastospersonales.data.AppDatabase
import com.example.misgastospersonales.data.Gasto
import com.example.misgastospersonales.data.GastoRepository
import com.example.misgastospersonales.data.SettingsRepository
import com.example.misgastospersonales.ui.Pantalla
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope

// Cambiamos de ViewModel a AndroidViewModel para poder acceder al contexto (Application)
//class GastosViewModel(application: Application) : AndroidViewModel(application) {
class GastosViewmodel(
    private val repository: GastoRepository
    private val settingsRepository: SettingsRepository
    ) : ViewModel() {

    // Lista observable para la UI que se actualizará automáticamente desde Room
    var listaGastos = mutableStateOf<List<Gasto>>(emptyList())
        private set
    //estado para controlar pantalla de navegacion actual
    var pantallaActual by mutableStateOf(Pantalla.FORMULARIO)
       private set
    var descripcion by mutableStateOf("")
       private set
    var montoInput by mutableStateOf("")
        private set

    fun onDescripcionChanged(nuevoTexto: String){
        descripcion = nuevoTexto
    }
    fun onMontoChanged(nuevoMonto: String) {
        montoInput = nuevoMonto
    }
    fun limpiarFormulario() {
        descripcion = ""
        montoInput = ""
    }
    fun cambiarPantalla(nuevaPantalla: Pantalla) {
        pantallaActual = nuevaPantalla
    }

    init {
        // Escuchamos los cambios de la base de datos en tiempo real
        viewModelScope.launch {
            repository.todosLosGastos.collectLatest { gastos ->
                listaGastos.value = gastos
            }
        }
    }

    // Función para agregar un gasto usando corrutinas (operación asíncrona)
    fun agregarGasto(descripcion: String,
                     monto: Int,
                     onExceedsLimit: (limite: Int, totalConNuevoGasto: Int) -> Unit,
                     onSuccess: () -> Unit
    ) {
        if (descripcion.isNotBlank() && monto > 0) {
            viewModelScope.launch {
                val limiteDiario = settingsRepository.dailyLimitFlow.firstOrNull() ?: 0
                val totalActual = listaGastos.value.sumOf {it.monto}
                val totalConNuevoGasto = totalActual + monto
                if (limiteDiario > 0 && totalConNuevoGasto > limiteDiario){
                    onExceedsLimit(limiteDiario, totalConNuevoGasto.toInt())
                }
                val nuevoGasto = Gasto(
                    descripcion = descripcion,
                    monto = monto
                )
                repository.insertar(nuevoGasto)
                onSuccess()
            }
        }
    }
}
