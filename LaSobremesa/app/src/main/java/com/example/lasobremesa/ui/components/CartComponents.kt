// La Sobremesa
// muestra productos y compras del carrito
//
package com.example.lasobremesa.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lasobremesa.ui.viewmodel.CartItem

class CartComponents {
}

@Composable
fun CartItemCard(
    item: CartItem,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit,
    onDelete: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Imagen del producto
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = item.title,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            // Información y Controles
            Column(modifier = Modifier.weight(1.8f)) {
                Text(text = "${item.title} - ${item.brand}", fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                Text(text = item.type, fontSize = 12.sp, color = Color.DarkGray, modifier = Modifier.padding(top = 4.dp))
                Text(text = item.deliveryInfo, fontSize = 12.sp, color = Color.Gray)

                Spacer(modifier = Modifier.height(8.dp))

                TextButton(onClick = onDelete, contentPadding = PaddingValues(0.dp)) {
                    Text(text = "Eliminar", fontSize = 12.sp, color = Color.Gray)
                }
            }

            // Precio y Contador de cantidad (+ / -)
            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier.weight(1.2f)
            ) {
                Text(
                    text = "$${String.format("%,.0f", item.price * item.quantity)}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .border(1.dp, Color.LightGray, RoundedCornerShape(4.dp))
                        .padding(horizontal = 4.dp, vertical = 2.dp)
                ) {
                    IconButton(onClick = onDecrease, modifier = Modifier.size(24.dp)) {
                        Text(text = "-", fontWeight = FontWeight.Bold)
                    }
                    Text(
                        text = item.quantity.toString(),
                        modifier = Modifier.padding(horizontal = 8.dp),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                    IconButton(onClick = onIncrease, modifier = Modifier.size(24.dp)) {
                        Text(text = "+", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}
// resumen de compra
@Composable
fun CartSummaryCard(
    subtotal: Double,
    onCheckoutClick: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Resumen de compra", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Productos", color = Color.Gray)
                Text(text = "$${String.format("%,.0f", subtotal)}", fontWeight = FontWeight.Medium)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Despacho", color = Color.Gray)
                Text(text = "Se calcula en el checkout", fontSize = 12.sp, color = Color.Gray)
            }

            Divider(modifier = Modifier.padding(vertical = 12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Total", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(text = "$${String.format("%,.0f", subtotal)}", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                //onClick = onCheckoutClick,
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "IR AL CHECKOUT", color = Color.White, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),

                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null,
                    modifier = Modifier.size(14.dp),
                    tint = Color.Gray
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Compra 100% segura", fontSize = 12.sp, color = Color.Gray)
            }
        }
    }
}