package com.fuze.features.matches.data.remote.model.response

import com.google.gson.annotations.SerializedName

/**
 * Class to get the league API response
 */
internal data class LeagueResponse(
        @SerializedName("id") val id: Long,
        @SerializedName("image_url") val imgUrl: String?,
        @SerializedName("name") val name: String,
)