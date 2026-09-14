package com.example.misgastospersonales.viewmodel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import com.example.misgastospersonales.data.Gasto

class GastosViewModel : ViewModel() {
    val listaGastos = mutableStateListOf<Gasto>()

    fun agregarGasto(descripcion: String, monto: Double) {
        if (descripcion.isNotBlank() && monto > 0) {
            listaGastos.add(Gasto(descripcion, monto))
        }
    }
}
