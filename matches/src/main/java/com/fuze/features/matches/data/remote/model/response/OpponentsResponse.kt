package com.fuze.features.matches.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class OpponentsResponse (
        @SerializedName("opponents")
        val opponentsResponse: List<OpponentList>
        ) {

    data class OpponentList(
        @SerializedName("players")
        val players : List<PlayersResponse>?
    )

}