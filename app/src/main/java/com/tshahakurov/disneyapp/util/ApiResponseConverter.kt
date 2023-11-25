package com.tshahakurov.disneyapp.util

import com.tshahakurov.disneyapp.model.Hero
import com.tshahakurov.disneyapp.model.network.HeroListResponse
import com.tshahakurov.disneyapp.model.network.HeroResponse

const val NO_IMAGE =
    "https://static.wikia.nocookie.net/disney/images/7/7c/Noimage.png/revision/latest?cb=20200418165215"

fun HeroListResponse.toHeroList(): ArrayList<Hero> {
    val list = arrayListOf<Hero>()
    data.forEach {
        list.add(
            it.toHero()
        )
    }
    return list
}

fun HeroResponse.toHero(): Hero {
    return data?.let {
        with(data) {
            Hero(
                id, name, imageUrl ?: NO_IMAGE,
                arrayListOf(
                    Hero.Characteristic(Hero.FILMS_FIELD, films),
                    Hero.Characteristic(Hero.SHORT_FILMS_FIELD, shortFilms),
                    Hero.Characteristic(Hero.TV_SHOWS_FIELD, tvShows),
                    Hero.Characteristic(Hero.VIDEO_GAMES_FIELD, videoGames),
                    Hero.Characteristic(Hero.PARK_ATTRACTIONS_FIELD, parkAttractions),
                    Hero.Characteristic(Hero.ALLIES_FIELD, allies),
                    Hero.Characteristic(Hero.ENEMIES_FIELD, enemies),
                )
            )
        }
    } ?: Hero(
        -1,
        "NO_DATA",
        NO_IMAGE,
        arrayListOf(Hero.Characteristic("", arrayListOf()))
    )
}

fun HeroResponse.Data.toHero(): Hero {
    return Hero(
        id, name, imageUrl ?: NO_IMAGE,
        arrayListOf(
            Hero.Characteristic(Hero.FILMS_FIELD, films),
            Hero.Characteristic(Hero.SHORT_FILMS_FIELD, shortFilms),
            Hero.Characteristic(Hero.TV_SHOWS_FIELD, tvShows),
            Hero.Characteristic(Hero.VIDEO_GAMES_FIELD, videoGames),
            Hero.Characteristic(Hero.PARK_ATTRACTIONS_FIELD, parkAttractions),
            Hero.Characteristic(Hero.ALLIES_FIELD, allies),
            Hero.Characteristic(Hero.ENEMIES_FIELD, enemies),
        )
    )
}