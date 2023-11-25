package com.tshahakurov.disneyapp.view.fragment.allheroes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tshahakurov.disneyapp.model.Hero
import com.tshahakurov.disneyapp.repository.HeroListRepository
import com.tshahakurov.disneyapp.util.toHeroList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroesListViewModel @Inject constructor(
    private val repository: HeroListRepository
) : ViewModel() {

    val heroList = MutableLiveData<ArrayList<Hero>>()
    val isLoading = MutableLiveData(false)

    fun getHeroList() {
        viewModelScope.launch(Dispatchers.IO) {
            isLoading.postValue(true)
            val response = repository.getHeroList()

            if (response.isSuccessful) {
                response.body()?.toHeroList().let {
                    heroList.postValue(it)
                }
            }
            isLoading.postValue(false)
        }
    }
}