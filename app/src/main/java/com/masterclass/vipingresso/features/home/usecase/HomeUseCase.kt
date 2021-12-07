package com.masterclass.vipingresso.features.home.usecase


import com.masterclass.vipingresso.features.home.repository.HomeRepository
import com.masterclass.vipingresso.features.model.modelResultAttractionSearch.ResultAttractionSearch
import com.masterclass.vipingresso.utils.ResponseApi


class HomeUseCase {

    private val homeRepository = HomeRepository()


    suspend fun getAttractionSearch(): ResponseApi {
        return when (val responseApi = homeRepository.getAttractionSearch()) {
            is ResponseApi.Success -> {
                val data = responseApi.data as ResultAttractionSearch
                val result = data._embedded.attractions
                ResponseApi.Success(result)
            }
            is ResponseApi.Error -> {
                responseApi
            }
        }

    }


}




