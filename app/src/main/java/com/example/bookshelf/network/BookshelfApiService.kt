package com.example.bookshelf.network

import com.example.bookshelf.model.Libro
import retrofit2.http.GET

interface BookshelfApiService {
    @GET("libros")
    suspend fun getLibros(): List<Libro>
}