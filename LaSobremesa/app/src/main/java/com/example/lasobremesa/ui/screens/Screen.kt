// LaSobremesa
// diseño de la pantalla principal con titulo y menu
//
package com.example.lasobremesa.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lasobremesa.ui.components.BottomNavigationBar
import com.example.lasobremesa.ui.components.BottomNavItem
import com.example.lasobremesa.ui.viewmodel.MainViewModel
import com.example.lasobremesa.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(mainViewModel: MainViewModel = viewModel()) {
    val navController = rememberNavController()
    var expandedMenu by remember { mutableStateOf(false) }

    //obtiene ruta Actual
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route


    //define titulo segun ruta actual
    val currentTitle = when (currentRoute) {
        "home" -> "Inicio"
        "Products" -> "Productos"
        "search" -> "Busqueda"
        "My Account" -> "Mi Cuenta"
        "more" -> "Mas"
        else -> "LA SOBREMESA"
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = currentTitle,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Left,
                        fontSize = 16.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver"
                        )
                    }
                },
                actions = {
                    // logo
                    Image(
                        painter = painterResource(id = R.drawable.img_lasobremesa),
                        contentDescription = "LaSobremesa Logo",
                        modifier = Modifier
                            .size(75.dp)
                            .padding(end = 12.dp)
                        // tint = Color.Unspecified
                    )
                    // buscar
                    IconButton(onClick = { navController.navigate("search"){
                        launchSingleTop = true }
                    }
                    ) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Buscar")
                    }
                    // carrito
                    IconButton(onClick = { navController.navigate("cart"){
                    launchSingleTop = true
                    }}) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "Carrito")
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                onTabSelected = { item ->
                    if (item.route == "more") {
                        expandedMenu = true
                    } else {
                        navController.navigate(item.route)
                    }
                })
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.BottomEnd) // Lo alinea abajo a la derecha (ajusta según prefieras)
                    // .padding(end = 24.dp, bottom = 8.dp)
                    .offset(x = (-50).dp, y = (-10).dp)
            )
            {
                // El menú que se despliega al presionarlo
                DropdownMenu(
                    expanded = expandedMenu,
                    onDismissRequest = { expandedMenu = false }
                ) {
                    DropdownMenuItem(
                        text = {
                            Column {
                                Text("Suscripcion")
                                Text(
                                    text = "Cajas mensuales con lo mejor de cada temporada",
                                    fontSize = 10.sp
                                )
                            }
                        },
                        onClick = {
                            expandedMenu = false
                            navController.navigate("suscripcion_route") // Reemplaza con tu ruta real
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Column {
                                Text("Historia de productores")
                                Text(
                                    text = "Conoce a quienes hay detrás de cada producto",
                                    fontSize = 10.sp
                                )
                            } },
                        onClick = {
                            expandedMenu = false
                            navController.navigate("historia_route") // Reemplaza con tu ruta real
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Column {
                                Text("Favoritos")
                                Text (
                                    text = "Tus productos guardados",
                                    fontSize = 10.sp
                                )
                            } },
                        onClick = {
                            expandedMenu = false
                            navController.navigate("favoritos_route") // Reemplaza con tu ruta real
                        })
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(BottomNavItem.Home.route) {
                HomeScreen(
                    onNavigateTo = { route -> navController.navigate(route) }
                )
            }
            // muestra grilla de productos
            composable(BottomNavItem.Products.route) {
                CatalogScreen(navController = navController)}
                //ruta detalle producto

            composable("search") {
                SearchScreen(
                    onNavigateTo = { route ->
                        navController.navigate(route)
                    }, onLogout = {}
                )
            }

            composable("cart") {
                CartScreen(
                    onNavigateToCheckout = {
                            navController.navigate(BottomNavItem.Home.route)
                    }
                )
            }

            composable(
                 route = "ProductDetailScreen/{productId}")
                 { backStackEntry ->
                     val productId = backStackEntry.arguments?.getString("productId") ?: ""
                     ProductDetailScreen(productId = productId, navController = navController)
                 }

            composable(BottomNavItem.Account.route) {
                AccountScreen(
                    onNavigate = { route -> navController.navigate(route) }
                )
            }
            //}
        }
    }
}
