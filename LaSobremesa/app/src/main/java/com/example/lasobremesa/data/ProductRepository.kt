package com.example.lasobremesa.data

import com.example.lasobremesa.R


class ProductRepository {
    private val products = listOf(
        Product(
            id = "1",
            name = "Vino Orgánico",
            producerId = "prod_1",
            category = "Vinos",
            imageRes = R.drawable.vinoorganico,
            price = 15000,
            description = "Vino orgánico elaborado respetando los ciclos naturales de la tierra " +
                    "De color intenso y aromas frutales. Ideal para acompañar carnes, quesos y pastas"
        ),
        Product(
            id = "2",
            name = "Queso Maduro",
            producerId = "prod_2",
            category = "Quesos",
            imageRes = R.drawable.img_queso_maduro,
            price = 12990,
            description = "Queso de leche de vaca madurado por más de 60 días. " +
                    "Sabor intenso y textura firme"
        ),
        Product(
            id = "3",
            name = "Mermelada de Frambuesa",
            producerId = "prod_3",
            category = "Mermeladas",
            imageRes = R.drawable.img_merm_frambuesa,
            price = 13980,
            description = "Mermelada casera elaborada con frambuesas frescas " +
            "Ideal para disfrutar en todo momento"
        ),
        Product(
            id = "4",
            name = "Aceite La Oliva",
            producerId = "prod_2",
            category = "Aceite Oliva",
            imageRes = R.drawable.aceitelaoliva,
            price = 25000,
            description = "Aceite de oliva extra virgen, de color verde dorado, aroma " +
                    "fresco y frutos verdes, Ideal para aderezar"
        )
    )
    // obtiene todos los productos
    fun getProducts(): List<Product> = products

    // obtiene un producto
    fun getProductById(id: String): Product? {
        return products.find { it.id == id }
    }
}
