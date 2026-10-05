// FT
// la estructura de gastos:detalle y monto
//
package com.example.misgastospersonales.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gastos")
data class Gasto(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val descripcion: String,
    val monto: Double
)