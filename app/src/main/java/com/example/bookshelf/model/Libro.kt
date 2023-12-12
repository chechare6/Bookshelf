package com.example.bookshelf.model;


import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;

@Serializable
data class Libro(
    val name: String,
    @SerialName("img_src") val imgSrc: String
)