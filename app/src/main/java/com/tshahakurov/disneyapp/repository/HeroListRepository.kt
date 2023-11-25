package com.tshahakurov.disneyapp.repository

import com.tshahakurov.disneyapp.network.DisneyApi
import javax.inject.Inject

class HeroListRepository @Inject constructor(
    private val disneyApi: DisneyApi
) {

    suspend fun getHeroList() = disneyApi.getHeroList()
}