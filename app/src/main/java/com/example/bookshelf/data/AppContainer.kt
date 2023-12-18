package com.example.bookshelf.data

<<<<<<< HEAD
import com.example.bookshelf.network.BookshelfApiService
=======

import com.example.bookshelf.network.BooksApiService
>>>>>>> 4a306b1d06a22ba5f161f203dfc82923737f3ac1
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

<<<<<<< HEAD
interface AppContainer {
    val librosRepository: LibrosRepository
}

class DefaultAppContainer : AppContainer {
    private val BASE_URL = "https://www.googleapis.com/books/v1/volumes?q=jazz+history"
=======

interface AppContainer {
    val booksRepository: BooksRepository
}
class DefaultAppContainer : AppContainer {
    private val BASE_URL = "https://books.google.com/books"
>>>>>>> 4a306b1d06a22ba5f161f203dfc82923737f3ac1

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

<<<<<<< HEAD
    private val retrofitService: BookshelfApiService by lazy {
        retrofit.create(BookshelfApiService::class.java)
    }

    override val librosRepository: LibrosRepository by lazy {
        DefaultLibrosRepository(retrofitService)
    }

=======

    private val retrofitService: BooksApiService by lazy {
        retrofit.create(BooksApiService::class.java)
    }

    override val booksRepository: BooksRepository by lazy {
        DefaultBooksRepository(retrofitService)
    }
>>>>>>> 4a306b1d06a22ba5f161f203dfc82923737f3ac1
}