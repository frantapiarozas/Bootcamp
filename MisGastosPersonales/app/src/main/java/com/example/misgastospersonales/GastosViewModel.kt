package com.example.misgastospersonales
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class GastosViewModel : ViewModel() {
    var gastos = mutableStateListOf<Gasto>()
    private set

    fun agregarGasto(detalle: String, monto: Double) {
        gastos.add(
            Gasto(
                detalle = detalle,
                monto = monto
            )
        )
    }
}