package com.example.misgastospersonales

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.misgastospersonales.data.AppDatabase
import androidx.room3.Room

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        val database = Room.databaseBuilder<AppDatabase> (
           context = applicationContext,
            name = applicationContext.getDatabasePath("gastos_database").absolutePath
        )
        .fallbackToDestructiveMigration(true)
        .build()
        setContent {
            App(database = database)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}