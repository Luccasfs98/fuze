package com.fuze.features.matches.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class SeriesResponse(
    @SerializedName("full_name")
    val fullName: String
)
