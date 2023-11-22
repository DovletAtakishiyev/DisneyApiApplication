package com.tshahakurov.disneyapp.view.fragment.allheroes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tshahakurov.disneyapp.db.DB
import com.tshahakurov.disneyapp.model.Hero
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HeroesListViewModel @Inject constructor(): ViewModel() {
    val list = MutableLiveData<ArrayList<Hero>>()

    fun getList(){
        list.value = DB.list
    }
}