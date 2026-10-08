//FT
//los gastos cuando se van a aplicar
//
package com.example.misgastospersonales.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface GastoDao {
    @Query("SELECT * FROM gastos")
    fun obtenerGastos(): Flow<List<Gasto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarGasto(gasto: Gasto)

    @Query("DELETE FROM gastos")
    suspend fun deleteAllGastos()
}