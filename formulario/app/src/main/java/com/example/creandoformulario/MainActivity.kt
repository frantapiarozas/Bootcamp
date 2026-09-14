// FT
// punto de entrada de la aplicacion y configuracion
//

package com.example.creandoformulario

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.creandoformulario.data.database.DataBaseHelper
import com.example.creandoformulario.data.repository.FormularioRepository
import com.example.creandoformulario.ui.screens.FormularioScreen
import com.example.creandoformulario.ui.screens.HistorialScreen
import com.example.creandoformulario.viewmodel.FormularioViewmodel

class MainActivity:ComponentActivity() {
    override fun
            onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dbHelper = DataBaseHelper(this)
        val repository = FormularioRepository(dbHelper)
        // val viewmodel = FormularioViewmodel(repository)

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //FormularioRegistro(viewModel = viewmodel)

                    val navController = rememberNavController()
                    val viewModel: FormularioViewmodel =
                        viewModel { FormularioViewmodel(repository) }

                    NavHost(navController = navController, startDestination = "formulario") {
                        composable("formulario") {
                            FormularioScreen(
                                viewModel = viewModel,
                                onNavegarHistorial = { navController.navigate("historial") }
                            )
                        }
                        composable("historial") {
                            HistorialScreen(
                                viewModel = viewModel,
                                onVolver = { navController.popBackStack() }
                            )
                        }
                    }
                }
            }
        }
    }
}

