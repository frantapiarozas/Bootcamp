// LaSobremesa
// componentes del menu : filtro y detalle producto
//
package com.example.lasobremesa.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
            // categorias: Quesos, Mermeladas......

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = selectedCategories.contains("Todos"),
                    onCheckedChange = { onCategoryToggled("Todos") }
                )
                Text("Todos")
            }
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

        }
    }
}
// muestra imagen y detalle de producto
@Composable
fun ProductCard(product: Product, onClick:(String) -> Unit) {
     Card(modifier = Modifier.fillMaxWidth()
         .clickable{
             onClick(product.id)
}) {
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
                 text = product.name,
                 style = MaterialTheme.typography.bodySmall,
                 color = Color.Gray
             )
             Text(text = "${product.price}", style = MaterialTheme.typography.titleMedium)
         }
     }
}
