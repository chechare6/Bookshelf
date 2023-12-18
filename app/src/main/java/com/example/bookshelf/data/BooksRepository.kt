package com.example.bookshelf.data

import com.example.bookshelf.model.Book
import com.example.bookshelf.network.BooksApiService

/**
 * Repository retrieves amphibian data from underlying data source.
 */
interface BooksRepository {
    /** Retrieves list of amphibians from underlying data source */
    suspend fun getBooks(): List<Book>
}


class DefaultBooksRepository(
    private val BooksApiService: BooksApiService
) : BooksRepository {
    override suspend fun getBooks(): List<Book> = BooksApiService.getBooks()
}