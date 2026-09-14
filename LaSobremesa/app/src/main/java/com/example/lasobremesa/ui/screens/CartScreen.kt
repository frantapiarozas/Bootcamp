// LaSobremesa
// pantalla de Carrito
//
package com.example.lasobremesa.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lasobremesa.ui.components.CartItemCard
import com.example.lasobremesa.ui.components.CartSummaryCard
import com.example.lasobremesa.ui.viewmodel.CartViewModel

@Composable
fun CartScreen(
    viewModel: CartViewModel = viewModel(),
    onCheckoutClick: () -> Unit = {}
) {
    val uiState by viewModel.uiState
        .collectAsState()

    Scaffold(
        topBar = {
            // TopBar personalizada con el logo "LA SOBREPRESA" e iconos
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFFF9F8F6)), // Tono de fondo claro similar al diseño
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Título: Tu carrito (X productos)
            item {
                Text(
                    text = "Tu carrito (${uiState.totalItemsCount} productos)",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }

            // Lista de productos
            items(uiState.items, key = { it.id }) { item ->
                CartItemCard(
                    item = item,
                    onIncrease = { viewModel.updateQuantity(item.id, item.quantity + 1) },
                    onDecrease = { viewModel.updateQuantity(item.id, item.quantity - 1) },
                    onDelete = { viewModel.removeItem(item.id) }
                )
            }

            // Resumen de Compra
            item {
                CartSummaryCard(
                    subtotal = uiState.subtotal,
                    onCheckoutClick = onCheckoutClick
                )
            }

            // Sección inferior "También te puede interesar" (Placeholder)
            /*item {
                Text(
                    text = "También te puede interesar",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp)
                )
                // Implementar un LazyRow horizontal para productos recomendados aquí si lo deseas
            }*/
        }
    }
}