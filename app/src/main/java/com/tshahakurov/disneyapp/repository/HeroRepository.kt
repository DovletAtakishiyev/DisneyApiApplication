package com.tshahakurov.disneyapp.repository

import com.tshahakurov.disneyapp.network.DisneyApi
import javax.inject.Inject

class HeroRepository @Inject constructor(
    private val disneyApi: DisneyApi
) {

    suspend fun getHero() = disneyApi.getHero()

    suspend fun getHeroById(id: Int) = disneyApi.getHeroById(id.toString())
}