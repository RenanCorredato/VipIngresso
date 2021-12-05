package com.masterclass.vipingresso.features.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masterclass.vipingresso.features.home.usecase.HomeUseCase
import kotlinx.coroutines.launch

class HomeViewModel:ViewModel() {

    private val homeUseCase = HomeUseCase()


    fun getEventSearch() {
        viewModelScope.launch {
            homeUseCase.getEventSearch()
        }
    }

}