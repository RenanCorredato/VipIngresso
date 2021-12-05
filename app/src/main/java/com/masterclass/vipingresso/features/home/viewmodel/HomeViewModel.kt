package com.masterclass.vipingresso.features.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masterclass.vipingresso.features.home.usecase.HomeUseCase
import com.masterclass.vipingresso.features.model.modelEventSearch.EventSearchResult
import com.masterclass.vipingresso.utils.ResponseApi
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val homeUseCase = HomeUseCase()

    private val _onSuccessEventSearchResult: MutableLiveData<List<EventSearchResult>> =
        MutableLiveData()

    val onSuccessEventSearchResult: LiveData<List<EventSearchResult>>
        get() = _onSuccessEventSearchResult

    private val _onErrorEventSearchResult: MutableLiveData<Int> =
        MutableLiveData()

    val onErrorEventSearchResult: LiveData<Int>
        get() = _onErrorEventSearchResult


    fun getEventSearch() {
        viewModelScope.launch {
            when(val responseApi = homeUseCase.getEventSearch()){
                is ResponseApi.Success -> {
                    _onSuccessEventSearchResult.postValue(responseApi.data as? List<EventSearchResult>)
                }
                is ResponseApi.Error ->{
                    _onErrorEventSearchResult.postValue(responseApi.message)
                }
            }
        }
    }

    fun getAttractionSearch() {
        viewModelScope.launch {
            homeUseCase.getAttractionSearch()
        }
    }

}