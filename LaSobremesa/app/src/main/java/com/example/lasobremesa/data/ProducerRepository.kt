package com.example.lasobremesa.data

class ProducerRepository {
    private val producers = listOf(
        Producer(
            id = "prod_1",
            name = "Vino Organico",
            ubicacion = "Casablanca",
            bio = "Productor artesanal de vinos organicos."
        ),
        Producer(
            id = "prod_2",
            name = "Don Pedro",
            ubicacion = "Talca",
            bio = "Productor artesanal de quesos y aceite de oliva ."
        ),
        Producer(
            id = "prod_3",
            name = "Gustoso gourmet",
            ubicacion = "Pichilemu",
            bio = "Productor artesanal de mermeladas y conservas."
        )
    )

    fun getProducerById(id: String): Producer? {
        return producers.find { it.id == id }
    }
}
