package com.masterclass.vipingresso.features.home.usecase


import com.masterclass.vipingresso.extensions.getDateBR
import com.masterclass.vipingresso.features.home.repository.HomeRepository
import com.masterclass.vipingresso.features.model.modelEventSearch.EventSearchResult
import com.masterclass.vipingresso.utils.ResponseApi


class HomeUseCase {
    private val homeRepository = HomeRepository()

    suspend fun getEventSearch(): ResponseApi {
        return when (val responseApi = homeRepository.getEventSearch()) {
            is ResponseApi.Success -> {
                val data = responseApi.data as? EventSearchResult
                val result = data?._embedded?.events?.map{
                    it.dates.start.localDate = it.dates.start.localDate.getDateBR()
                    it
                }
                ResponseApi.Success(result)
            }

            is ResponseApi.Error ->{
                responseApi
            }

        }

    }

    suspend fun getAttractionSearch(): ResponseApi {
        return homeRepository.getAttractionSearch()
    }

}