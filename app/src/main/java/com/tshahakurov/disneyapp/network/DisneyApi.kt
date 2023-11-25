package com.tshahakurov.disneyapp.network

import com.tshahakurov.disneyapp.model.network.HeroListResponse
import com.tshahakurov.disneyapp.model.network.HeroResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DisneyApi {

    @GET("character/206")
    suspend fun getHero(): Response<HeroResponse>

    @GET("character/{id}")
    suspend fun getHeroById(@Path("id") id: String): Response<HeroResponse>

    @GET("character")
    suspend fun getHeroList(@Query("pageSize") count: Int = 149): Response<HeroListResponse>
}