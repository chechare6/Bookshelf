package com.example.bookshelf.network

import com.example.bookshelf.model.Book
import retrofit2.http.GET

interface BooksApiService {
    @GET("books")
    suspend fun getBooks(): List<Book>
}