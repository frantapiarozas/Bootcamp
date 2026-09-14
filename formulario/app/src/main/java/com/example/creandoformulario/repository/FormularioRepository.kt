// FT
// repositorio del formulario
//
package com.example.creandoformulario.data.repository

import android.content.ContentValues
import com.example.creandoformulario.data.database.DataBaseHelper

class FormularioRepository(private val dbHelper: DataBaseHelper) {

    fun guardarFormulario(nombre: String, correo: String): Long {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(DataBaseHelper.COLUMN_NOMBRE, nombre)
            put(DataBaseHelper.COLUMN_CORREO, correo)
        }
        return db.insert(DataBaseHelper.TABLE_REGISTROS, null, values)
    }

fun obtenerRegistros(): List<Pair<String, String>> {
    return dbHelper.obtenerTodosLosRegistros()
}
}