package com.example.bookshelf.model

import androidx.compose.foundation.lazy.grid.GridItemSpan
import com.google.gson.annotations.SerializedName

data class Bookshelf(
    @SerializedName("kind") var kind : String ? = null,
    @SerializedName("totalItems") var totalItems : Int ? = null,
    @SerializedName("items") var items : ArrayList<Items> = arrayListOf()
)
