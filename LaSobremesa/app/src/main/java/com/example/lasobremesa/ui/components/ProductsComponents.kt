// LaSobremesa
// componentes del menu : filtro y detalle producto
//
package com.example.lasobremesa.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.lasobremesa.data.Product

// muestra menu deplegable de filtros
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FiltrosSection(
    selectedCategories: Set<String>,
    selectedProducers: Set<String>,
    onCategoryToggled: (String) -> Unit,
    onProducerToggled: (String) -> Unit,
    onDismiss: () -> Unit
) {
    val scrollState = rememberScrollState()
    ModalBottomSheet(onDismissRequest = onDismiss) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .verticalScroll(scrollState)
        ) {
            Text(
                "Filtros", style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))
            Text("CATEGORÍAS", style = MaterialTheme.typography.labelMedium)
            Spacer(modifier = Modifier.height(16.dp))

            // categorias: Quesos, Mermeladas......
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = selectedCategories.contains("Quesos"),
                    onCheckedChange = { onCategoryToggled("Quesos") }
                )
                Text("Quesos")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = selectedCategories.contains("Mermeladas"),
                    onCheckedChange = { onCategoryToggled("Mermeladas") }
                )
                Text("Mermeladas")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = selectedCategories.contains("Aceite Oliva"),
                    onCheckedChange = { onCategoryToggled("Aceite Oliva") }
                )
                Text("Aceite Oliva")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = selectedCategories.contains("Vinos"),
                    onCheckedChange = { onCategoryToggled("Vinos") }
                )
                Text("Vinos")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = selectedCategories.contains("Conservas"),
                    onCheckedChange = { onCategoryToggled("Conservas") }
                )
                Text("Conservas")
            }


            Spacer(modifier = Modifier.height(12.dp))
            Text("PRODUCTOR", style = MaterialTheme.typography.labelMedium)
            // Opciones de productores con checkbox
            Spacer(modifier = Modifier.height(12.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = false, onCheckedChange = {})
                Text("Don Pedro")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = false, onCheckedChange = {})
                Text("Gustoso Gourmet")
            }

            Spacer(modifier = Modifier.height(12.dp))
            Text("CONSERVACIÓN", style = MaterialTheme.typography.labelMedium)
//            FilterCheckbox(label = "Refrigerado")
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = false, onCheckedChange = {})
                Text("Refrigerado")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = false, onCheckedChange = {})
                Text("Congelado")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = false, onCheckedChange = {})
                Text("Ambiente")
            }

            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = onDismiss, modifier = Modifier.fillMaxWidth()) {
                Text("Aplicar")
            }
        }
    }
}
// muestra imagen y detalle de producto
@Composable
fun ProductCard(product: Product) {
     Card(modifier = Modifier.fillMaxWidth()) {
         Column(modifier = Modifier.padding(8.dp)) {
             // Imagen desde drawable
             Image(
                 painter = painterResource(id = product.imageRes),
                 contentDescription = product.name,
                 modifier = Modifier
                     .height(120.dp)
                     .fillMaxWidth()
                     .clip(RoundedCornerShape(8.dp)),
                 contentScale = ContentScale.Crop
             )

             Spacer(modifier = Modifier.height(8.dp))
             Text(text = product.name, style = MaterialTheme.typography.bodyMedium)
             Text(
                 text = product.producer,
                 style = MaterialTheme.typography.bodySmall,
                 color = Color.Gray
             )
             Text(text = "${product.price}", style = MaterialTheme.typography.titleMedium)
         }
     }
}
