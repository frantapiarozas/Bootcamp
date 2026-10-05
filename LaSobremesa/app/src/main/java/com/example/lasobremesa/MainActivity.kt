// LaSobremesa
// llama a pantalla principal
//
package com.example.lasobremesa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.lasobremesa.ui.screens.MainScreen
import com.example.lasobremesa.ui.theme.LaSobremesaTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaSobremesaTheme {
                MainScreen()
            }

        }
    }
}


