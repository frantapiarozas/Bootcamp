// LaSobremesa
// barra de navegacion de bottombar
//
package com.example.lasobremesa.ui.components

import androidx.compose.material.icons.Icons
// import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(
    navController: NavController,
    onTabSelected: (BottomNavItem) -> Unit
) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Products,
        //BottomNavItem.History,
        BottomNavItem.Cart,
        BottomNavItem.Account
    )
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = { Text(item.title) },
                selected = currentRoute == item.route,
                onClick = {
                    onTabSelected(item)
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

sealed class BottomNavItem(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomNavItem("home", "Inicio", Icons.Default.Home)
    object Products : BottomNavItem("Products", "Productos", Icons.Default.Storefront)
  //  object History : BottomNavItem("History", "Historia", Icons.Default.History)
    object Cart : BottomNavItem("Cart", "Carrito", Icons.Default.ShoppingCart)
    object Account : BottomNavItem("My Account", "Mi Cuenta", Icons.Default.Person)
}