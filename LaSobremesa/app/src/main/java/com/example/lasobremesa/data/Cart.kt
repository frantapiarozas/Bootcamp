package com.example.lasobremesa.data

data class CartItem(
    val id: String,
    val title: String,
    val brand: String,
    val type: String, // Ej: "Refrigerado", "Ambiente"
    val deliveryInfo: String,
    val price: Double,
    val quantity: Int,
    val imageRes: Int
)