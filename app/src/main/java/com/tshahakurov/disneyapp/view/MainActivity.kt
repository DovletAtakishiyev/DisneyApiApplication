package com.tshahakurov.disneyapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tshahakurov.disneyapp.R
import com.tshahakurov.disneyapp.view.fragment.allheroes.HeroesListFragment
import com.tshahakurov.disneyapp.view.fragment.allheroes.adapter.HeroesListAdapter
import com.tshahakurov.disneyapp.view.fragment.heroinfo.HeroInfoFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, HeroesListFragment())
            .commit()
    }
}