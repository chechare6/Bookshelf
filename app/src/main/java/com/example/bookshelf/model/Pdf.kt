package com.example.bookshelf.model

import com.google.gson.annotations.SerializedName

data class Pdf(
    @SerializedName("isAvailable") var isAvailable : Boolean ? = null
)
