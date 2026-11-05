package com.example.misgastospersonales

/*expect class Platform() {
    val name: String
}*/

interface Platform {
    val name: String
}
expect fun getPlatform(): Platform