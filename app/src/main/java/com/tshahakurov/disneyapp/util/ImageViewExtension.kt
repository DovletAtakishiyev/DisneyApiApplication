package com.tshahakurov.disneyapp.util

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImageUrl(url: String) {
    Glide.with(context)
        .load(url)
        .into(this)
}