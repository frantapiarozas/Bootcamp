// LaSobremesa
// la vista de la cuenta del usuario
//
package com.example.lasobremesa.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class AccountUiState(
    val proximaCajaEntrega: String = "",
    val proximaCajaCobro: String = "",
    val ultimoPedidoId: String = "",
    val ultimoPedidoEstado: String = ""
)

class AccountViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        AccountUiState(
            proximaCajaEntrega = "24 - 26 ago",
            proximaCajaCobro = "20 ago",
            ultimoPedidoId = "#88291",
            ultimoPedidoEstado = "En camino"
        )
    )
    val uiState: StateFlow<AccountUiState> = _uiState.asStateFlow()
}
