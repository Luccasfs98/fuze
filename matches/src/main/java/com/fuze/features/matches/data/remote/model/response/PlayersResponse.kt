package com.fuze.features.matches.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class PlayersResponse(
    @SerializedName("name")
    val nickname : String?,
    @SerializedName("first_name")
    val name : String?,
    @SerializedName("last_name")
    val lastName : String?,
    @SerializedName("image_url")
    val imgUrl: String?,
    @SerializedName("current_team")
    val currentTeam: CurrentTeam?
) {

    data class CurrentTeam(
        val id : Long
    )
}
