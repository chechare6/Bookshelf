package com.example.bookshelf.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
data class Book(
    val name: String,
    val type: String,
    val description: String,
    @SerialName("img_src") val imgSrc: String
)