package com.masterclass.vipingresso.features.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.masterclass.vipingresso.base.BaseViewModel
import com.masterclass.vipingresso.features.home.usecase.HomeUseCase
import com.masterclass.vipingresso.features.model.modelAttractionSearch.AttractionSearchResult
import com.masterclass.vipingresso.features.model.modelEventSearch.EventSearchResult
import kotlinx.coroutines.launch

class HomeViewModel : BaseViewModel() {

    private val homeUseCase = HomeUseCase()

    private val _onSuccessEventSearchResult: MutableLiveData<List<EventSearchResult>> =
        MutableLiveData()

    val onSuccessEventSearchResult: LiveData<List<EventSearchResult>>
        get() = _onSuccessEventSearchResult

    private val _onErrorEventSearchResult: MutableLiveData<Int> =
        MutableLiveData()

    val onErrorEventSearchResult: LiveData<Int>
        get() = _onErrorEventSearchResult

    //------------------------//------------------//

    private val _onSuccessAttractionSearchResult: MutableLiveData<AttractionSearchResult> =
        MutableLiveData()

    val onSuccessAttractionSearchResult: LiveData<AttractionSearchResult>
        get() = _onSuccessAttractionSearchResult

    private val _onErrorAttractionSearchResult: MutableLiveData<Int> =
        MutableLiveData()

    val onErrorAttractionSearchResult: LiveData<Int>
        get() = _onErrorAttractionSearchResult


    fun getEventSearch() {
        viewModelScope.launch {
            callApi(
                suspend { homeUseCase.getEventSearch() },
                onSuccess = {
                    val result = it as? List<*>
                    _onSuccessEventSearchResult.postValue(
                        result?.filterIsInstance<EventSearchResult>()
                    )
                }
            )
        }
    }

    fun getAttractionSearch() {
        viewModelScope.launch {
            callApi(
                suspend { homeUseCase.getAttractionSearch() },
                onSuccess = {
                    _onSuccessAttractionSearchResult.postValue(
                        it as? AttractionSearchResult
                    )
                }
            )
        }
    }

}