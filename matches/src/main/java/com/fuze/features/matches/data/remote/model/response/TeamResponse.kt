package com.fuze.features.matches.data.remote.model.response

import com.google.gson.annotations.SerializedName

/**
 * Class to get the matches API response
 */
internal data class TeamResponse(
        @SerializedName("opponent") val team: Team
){
        data class Team(
                @SerializedName("id") val id: Long,
                @SerializedName("image_url") val imageUrl: String?,
                @SerializedName("name") val name: String
        )
}