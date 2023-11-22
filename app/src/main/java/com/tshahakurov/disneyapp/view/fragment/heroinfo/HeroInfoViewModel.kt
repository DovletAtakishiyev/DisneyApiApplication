package com.tshahakurov.disneyapp.view.fragment.heroinfo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tshahakurov.disneyapp.db.DB
import com.tshahakurov.disneyapp.model.Hero
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HeroInfoViewModel @Inject constructor() : ViewModel() {
    var hero = MutableLiveData<Hero>()
    val list = MutableLiveData<ArrayList<Hero.Characteristic>>()

    fun getHeroByUrl(url: String){
        hero.value = DB.getHeroByUrl(url)
    }

    fun getList() {
        list.value = hero.value?.characteristicList
    }
}