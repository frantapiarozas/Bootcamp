// LaSobremesa
// pantalla home
//
package com.example.lasobremesa.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lasobremesa.ui.components.CategoryCard
import com.example.lasobremesa.ui.components.FooterInfoItem
import com.example.lasobremesa.ui.viewmodel.HomeViewModel
import com.example.lasobremesa.R
import androidx.compose.foundation.Image

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(),
    onNavigateTo: (String) -> Unit = {}
) {
    val state by viewModel.uiState.collectAsState()
    val scrollState = rememberScrollState()

    Scaffold(
        containerColor = Color(0xFFFDFBF7)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(scrollState)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Cabecera Principal
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = state.mainTitle,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.Black,
                lineHeight = 32.sp
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = state.mainDescription,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                color = Color.DarkGray,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Botones de acción principales
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Button(
                    onClick = { onNavigateTo("products") },
                    modifier = Modifier.weight(1f).height(46.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E1E1E)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("VER PRODUCTOS", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                }

                OutlinedButton(
                  //  onClick = { onNavigateTo("box") },
                    onClick = {},
                    modifier = Modifier.weight(1f).height(46.dp),
                    border = BorderStroke(1.dp, Color.Black),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black)
                ) {
                    Text("CONOCE LA CAJA", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Sección Categorías (5 productos)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "CATEGORÍAS", fontWeight = FontWeight.Bold, fontSize = 15.sp, color = Color.Black)
                TextButton(onClick = { onNavigateTo("categories") }){ }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                state.categories.forEach { category ->
                    CategoryCard(
                        product = category,
                        onClick = { viewModel.onCategoryClick(category) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(36.dp))

            // Sección Caja Gourmet Mensual
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF4F1EA)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1.2f)) {
                        Text(
                            text = state.gourmetBoxTitle,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = state.gourmetBoxDescription,
                            fontSize = 12.sp,
                            color = Color.DarkGray,
                            lineHeight = 16.sp
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Button(
                            //onClick = { onNavigateTo("subscription") },
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E1E1E)),
                            shape = RoundedCornerShape(6.dp),
                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                        ) {
                            Text("CONOCER SUSCRIPCIÓN", fontSize = 10.sp)
                        }
                    }

                    Spacer(modifier = Modifier.width(8.dp))
                    Image(
                        painter = painterResource(id = R.drawable.img_caja),
                        contentDescription = "Caja Gourmet",
                        modifier = Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(12.dp)),
                        contentScale = ContentScale.Crop
                    )
                 }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Footer inferior
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                FooterInfoItem(icon = Icons.Default.LocalShipping, title = "Despacho seguro", subtitle = "a todo el país")
                FooterInfoItem(icon = Icons.Default.Info, title = "Información clara", subtitle = "y transparente")
                FooterInfoItem(icon = Icons.Default.AccountCircle, title = "Apoyo local", subtitle = "a pequeños productores")
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}