package com.example.misgastospersonales.viewmodel

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.misgastospersonales.data.AppDatabase
import com.example.misgastospersonales.data.Gasto
import com.example.misgastospersonales.data.GastoRepository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

// Cambiamos de ViewModel a AndroidViewModel para poder acceder al contexto (Application)

class GastosViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: GastoRepository

    // Lista observable para la UI que se actualizará automáticamente desde Room
    var listaGastos = mutableStateOf<List<Gasto>>(emptyList())
        private set

    init {
        // Inicializamos la base de datos y el repositorio
        val gastoDao = AppDatabase.obtenerBaseDatos(application).gastoDao()
        repository = GastoRepository(gastoDao)

        // Escuchamos los cambios de la base de datos en tiempo real
        viewModelScope.launch {
            repository.todosLosGastos.collectLatest { gastos ->
                listaGastos.value = gastos
            }
        }
    }

    // Función para agregar un gasto usando corrutinas (operación asíncrona)
    fun agregarGasto(descripcion: String, monto: Double) {
        if (descripcion.isNotBlank() && monto > 0.0) {
            viewModelScope.launch {
                val nuevoGasto = Gasto(
                    descripcion = descripcion,
                    monto = monto
                )
                repository.insertar(nuevoGasto)
            }
        }
    }

    // funcion para borrar gastos
    fun clearHistory() {
        viewModelScope.launch {
            repository.deleteAllGastos()
        }
    }
}
