// FT
// administra los datos del formulario
//
package com.example.creandoformulario.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.creandoformulario.data.repository.FormularioRepository
import kotlinx.coroutines.launch
import kotlin.collections.emptyList

class FormularioViewmodel(
    private val repository: FormularioRepository
) : ViewModel() {

    // Variables que almacenan datos ingresados en formulario
    var nombre by mutableStateOf("")
        private set

    var correo by mutableStateOf("")
        private set

    // actualiza nombre y correo cuando usuario escribe
    fun onNombreChange(nuevoNombre: String) {
        nombre = nuevoNombre
    }

    fun onCorreoChange(nuevoCorreo: String) {
        correo = nuevoCorreo
    }

    // Método para guardar directamente en la base de datos a través del repositorio
    fun guardar() {
        if (nombre.isNotBlank() && correo.isNotBlank()) {
            // Llama a la función de tu FormularioRepository que inserta en SQLite
            repository.guardarFormulario(nombre, correo)

            // Limpia las cajas de texto tras guardar
            nombre = ""
            correo = ""
            // actualiza lista mostrada
            obtenerHistorial()
        }
    }
    // historial de registros guardados
      var historialList by mutableStateOf<List<Pair<String,String>>>(emptyList())
        private set
    init {
        obtenerHistorial()
    }
    // obtiene registros de la base de datos
    fun obtenerHistorial() {
        viewModelScope.launch {
            historialList = repository.obtenerRegistros()
        }
    }
}