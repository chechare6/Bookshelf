package com.example.bookshelf.network

import com.example.bookshelf.model.Bookshelf
import retrofit2.http.GET
import retrofit2.http.Query

interface BookshelfApiService {
    @GET("volumes")
    suspend fun getLibros(
        @Query("q") query: String,
        @Query("maxResults") maxResults: Int
    ): Bookshelf
}
