//FT
//repositorio de gastos
//
package com.example.misgastospersonales.data

import kotlinx.coroutines.flow.Flow

class GastoRepository(private val gastoDao: GastoDao) {
    val todosLosGastos: Flow<List<Gasto>> = gastoDao.obtenerGastos()

    suspend fun insertar(gasto: Gasto) {
        gastoDao.insertarGasto(gasto)
    }
    suspend fun deleteAllGastos() {
        gastoDao.deleteAllGastos()
    }
}
