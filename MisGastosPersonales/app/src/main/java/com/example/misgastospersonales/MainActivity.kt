// FT
// punto de inicio de la app
//

package com.example.misgastospersonales

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.misgastospersonales.ui.MainScreen
import com.example.misgastospersonales.viewmodel.GastosViewModel

class MainActivity : ComponentActivity() {
//inicializa el viewmodel usando kotlin
    private val gastosViewModel by viewModels<GastosViewModel>()

    // conecta el viewModel con el mainActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // le pasa el ViewModel a la pantalla
        setContent {
            MainScreen(viewModel = gastosViewModel)
            }
        }
    }
