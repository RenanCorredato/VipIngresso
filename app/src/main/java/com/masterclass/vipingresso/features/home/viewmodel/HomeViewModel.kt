package com.masterclass.vipingresso.features.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masterclass.vipingresso.api.ApiError.message
import com.masterclass.vipingresso.base.BaseViewModel
import com.masterclass.vipingresso.features.home.usecase.HomeUseCase
import com.masterclass.vipingresso.features.model.modelResultAttractionSearch.Attraction
import com.masterclass.vipingresso.features.model.modelResultAttractionSearch.Classification
import com.masterclass.vipingresso.features.model.modelResultAttractionSearch.Embedded
import com.masterclass.vipingresso.features.model.modelResultAttractionSearch.ResultAttractionSearch
import com.masterclass.vipingresso.utils.ResponseApi
import kotlinx.coroutines.launch


class HomeViewModel : BaseViewModel() {

    private val homeUseCase = HomeUseCase()

    private val _onSuccessAttractionSearch: MutableLiveData<List<ResultAttractionSearch>> =
        MutableLiveData()

    val onSuccessAttractionSearch: LiveData<List<ResultAttractionSearch>>
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
                        result?.filterIsInstance<ResultAttractionSearch>()
                    )
                }
            )
        }
    }
}

