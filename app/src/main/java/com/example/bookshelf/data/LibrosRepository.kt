package com.example.bookshelf.data

import com.example.bookshelf.model.Libro
import com.example.bookshelf.network.BookshelfApiService

interface LibrosRepository {
    suspend fun getLibros(): List<Libro>
}

class DefaultLibrosRepository(
    private val librosApiService: BookshelfApiService
) : LibrosRepository {
    override suspend fun getLibros(): List<Libro> = librosApiService.getLibros()
}