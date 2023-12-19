package com.example.bookshelf.data

import com.example.bookshelf.network.BookshelfApiService


interface LibrosRepository {
    suspend fun getLibros(query: String, maxResults: Int): List<Libro>
}

class DefaultLibrosRepository(
    private val librosApiService: BookshelfApiService
) : LibrosRepository {
    override suspend fun getLibros(
        query: String, maxResults: Int
    ): List<Libro> = librosApiService.getLibros(query, maxResults).items.map { items ->
        Libro(
            title = items.volumeInfo?.title,
            previewLink = items.volumeInfo?.previewLink,
            imageLink = items.volumeInfo?.imageLinks?.thumbnail
        )
    }
}


