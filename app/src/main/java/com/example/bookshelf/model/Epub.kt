package com.example.bookshelf.model

import com.google.gson.annotations.SerializedName

data class Epub(
    @SerializedName("isAvailable") var isAvailable : Boolean ? = null
)
