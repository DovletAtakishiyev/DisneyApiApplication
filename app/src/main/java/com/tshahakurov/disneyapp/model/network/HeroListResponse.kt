package com.tshahakurov.disneyapp.model.network

import com.google.gson.annotations.SerializedName

data class HeroListResponse(
    @SerializedName("data")
    val data: ArrayList<HeroResponse.Data>
)