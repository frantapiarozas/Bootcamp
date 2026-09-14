// La Sobremesa
// pantalla de productos
//
package com.example.lasobremesa.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lasobremesa.ui.viewmodel.ProductsViewModel
import com.example.lasobremesa.ui.components.FiltrosSection
import com.example.lasobremesa.ui.components.ProductCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogScreen(viewModel: ProductsViewModel = viewModel()) {
    val state by viewModel.uiState.collectAsState()
    var showBottomSheet by remember { mutableStateOf(false)}

    Scaffold(
        topBar = {
            TopAppBar(
                title =
                    { Text("Catalogo") })
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp).fillMaxWidth()
        ) {
            // Botón que abre el menu de filtros
            Button(onClick = { showBottomSheet = true }) {
                Text("Filtrar y Ordenamiento")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Grilla de Productos
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxWidth().weight(1f),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(state.products)
                { product -> ProductCard(product = product) }
            }
        }

        // Desplegar el BottomSheet cuando se active el botón
        if (showBottomSheet) {
            FiltrosSection(
                selectedCategories = state.selectedCategories,
                selectedProducers = state.selectedProducers,
                onCategoryToggled = { category -> viewModel.onCategoryToggled(category) },
                onProducerToggled = { producer -> viewModel.onProducerToggled(producer) },
                onDismiss = { showBottomSheet = false }
            )
        }
    }
}

