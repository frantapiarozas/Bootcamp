package com.example.misgastospersonales

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
//import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
//import androidx.compose.ui.tooling.preview.Preview
//import com.example.misgastospersonales.ui.theme.MisGastosPersonalesTheme

class MainActivity : ComponentActivity() {
//inicializa el viewmodel usando kotlin
    private val gastosViewModel: GastosViewModel by viewModels()

    // conecta el viewModel con el mainActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // le pasa el ViewModel a la pantalla
        setContent {
            Column {
                //ahora si existe gastosViewModel
                MisGastos(gastosViewModel)
            }
        }
    }
}

    @Composable
    fun MisGastos(vm: GastosViewModel) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Text(text = "Mis Gastos")
                Column {
                    Text(
                        text = "Cantidad de gastos: ${vm.gastos.size}"
                    )
                }
        }
    }
