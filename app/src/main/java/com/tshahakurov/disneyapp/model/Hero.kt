package com.tshahakurov.disneyapp.model

data class Hero(
    val name: String,
    val imageUrl: String,
    val url: String,
    val characteristicList: ArrayList<Characteristic>
) {
    data class Characteristic(
        val key: String = "",
        val value: ArrayList<String> = arrayListOf()
    )
}