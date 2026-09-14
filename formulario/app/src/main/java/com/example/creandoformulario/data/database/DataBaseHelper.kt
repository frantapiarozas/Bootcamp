// FT
// base de datos de la app
//
package com.example.creandoformulario.data.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(context: Context) : SQLiteOpenHelper(
    context,
    DATABASE_NAME,
    null,
    DATABASE_VERSION
) {
    companion object {
        const val DATABASE_NAME = "formulario.db"
        const val DATABASE_VERSION = 1
        const val TABLE_REGISTROS = "registros"
        const val COLUMN_ID = "_id"
        const val COLUMN_NOMBRE = "nombre"
        const val COLUMN_CORREO = "correo"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = """
            CREATE TABLE $TABLE_REGISTROS (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_NOMBRE TEXT NOT NULL,
                $COLUMN_CORREO TEXT NOT NULL
            )
        """.trimIndent()
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_REGISTROS")
        onCreate(db)
    }

    fun obtenerTodosLosRegistros(): List<Pair<String, String>> {
        val lista = mutableListOf<Pair<String, String>>()
        val db = readableDatabase
        val query = "SELECT $COLUMN_NOMBRE, $COLUMN_CORREO FROM $TABLE_REGISTROS"

        db.rawQuery(query, null).use { cursor ->
            val indexNombre = cursor.getColumnIndexOrThrow(COLUMN_NOMBRE)
            val indexCorreo = cursor.getColumnIndexOrThrow(COLUMN_CORREO)

            while (cursor.moveToNext()) {
                val nombre = cursor.getString(indexNombre)
                val correo = cursor.getString(indexCorreo)
                lista.add(Pair(nombre, correo))
            }
        }
        return lista
    }
}
