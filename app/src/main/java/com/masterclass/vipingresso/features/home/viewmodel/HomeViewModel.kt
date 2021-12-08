package com.masterclass.vipingresso.features.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.masterclass.vipingresso.base.BaseViewModel
import com.masterclass.vipingresso.features.home.usecase.HomeUseCase
import com.masterclass.vipingresso.features.model.teste.model.Result
import kotlinx.coroutines.launch


class HomeViewModel : BaseViewModel() {

    private val homeUseCase = HomeUseCase()

    private val _onSuccessAttractionSearch: MutableLiveData<List<Result>> =
        MutableLiveData()

    val onSuccessAttractionSearch: LiveData<List<Result>>
        get() = _onSuccessAttractionSearch

    private val _onErrorAttractionSearch: MutableLiveData<Int> =
        MutableLiveData()

    val onErrorAttractionSearch: LiveData<Int>
        get() = _onErrorAttractionSearch


    fun getAttractionSearch() {
        viewModelScope.launch {
            callApi(
                suspend { homeUseCase.getAttractionSearch() },
                onSuccess = {
                    val result = it as? List<*>
                    _onSuccessAttractionSearch.postValue(
                        result?.filterIsInstance<Result>()
                    )
                }
            )
        }
    }

    fun getAttractionDetailsId(id: Int) {
        viewModelScope.launch {
            callApi(
                suspend { homeUseCase.getAttractionDetailsId(id)},
                onSuccess = {
                    it
                }
            )
        }
    }

}



