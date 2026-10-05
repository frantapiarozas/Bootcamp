// LaSobremesa
// Define estructura deñ producto
//
package com.example.lasobremesa.data

data class Product (
    val id: String,
    val name: String,
    val producerId: String,
    val category: String,
    val imageRes: Int,
    val price: Int,
    val description: String
)
