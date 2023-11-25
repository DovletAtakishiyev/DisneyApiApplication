package com.tshahakurov.disneyapp.view.fragment.heroinfo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tshahakurov.disneyapp.model.Hero
import com.tshahakurov.disneyapp.repository.HeroRepository
import com.tshahakurov.disneyapp.util.toHero
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroInfoViewModel @Inject constructor(
    private val repository: HeroRepository
) : ViewModel() {

    val hero = MutableLiveData<Hero>()
    val isLoading = MutableLiveData(false)

    fun getHeroById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            isLoading.postValue(true)
            val response = repository.getHeroById(id)

            if (response.isSuccessful) {
                response.body()?.toHero().let {
                    hero.postValue(it)
                }
            }
            isLoading.postValue(false)
//            Log.d("suita", "id = ${id}")
        }
    }
}