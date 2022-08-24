package com.ddm.gallery_test


data class Photo(
    val id: String,
    val urls: Urls,
    val user: User
) {
    data class Urls(
        val raw: String,
        val full: String,
        val regular: String,
        val small: String,
        val thumb: String,
        val small_s3: String
    )

    data class User(val name: String)
}
