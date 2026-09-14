// LaSobremesa
// diseño de la pantalla principal con titulo y menu
//
package com.example.lasobremesa.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lasobremesa.ui.components.BottomNavigationBar
import com.example.lasobremesa.ui.components.BottomNavItem
import com.example.lasobremesa.ui.viewmodel.MainViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(mainViewModel: MainViewModel = viewModel()) {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "LA SOBREMESA",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* Menú */ }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menú"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* Buscar */ }) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Buscar")
                    }
                    IconButton(onClick = { /* Favoritos */ }) {
                        Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = "Favoritos")
                    }
                    IconButton(onClick = { navController.navigate(BottomNavItem.Account.route) }) {
                        Icon(imageVector = Icons.Default.Person, contentDescription = "Perfil")
                    }
                    IconButton(onClick = { navController.navigate("cart") }) {
                        Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Carrito")
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                onTabSelected = { item ->
                    navController.navigate(item.route)
                })
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
            composable(BottomNavItem.Products.route) {
                CatalogScreen(
                    // onNavigateTo = { route -> navController.navigate(route) },
                   //onLogout = { navController.navigate(BottomNavItem.Home.route) }
                )
            }
           /* composable(BottomNavItem.History.route) {
                HistoryScreen(
                    onNavigateTo = { route -> navController.navigate(route) },
                    onLogout = { navController.navigate(BottomNavItem.Home.route) }
                )
            }*/
            composable(BottomNavItem.Cart.route) {
                CartScreen(
                    onCheckoutClick = {
                        navController.navigate(BottomNavItem.Home.route)
                    }
                 )
            }
            composable(BottomNavItem.Account.route) {
                AccountScreen(
                    onNavigate = { route -> navController.navigate(route) }
                )
            }
        }
    }
}





