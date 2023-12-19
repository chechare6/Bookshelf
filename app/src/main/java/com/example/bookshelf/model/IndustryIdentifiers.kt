package com.example.bookshelf.model

import com.google.gson.annotations.SerializedName

data class IndustryIdentifiers(
    @SerializedName("type"       ) var type       : String? = null,
    @SerializedName("identifier" ) var identifier : String? = null
)
