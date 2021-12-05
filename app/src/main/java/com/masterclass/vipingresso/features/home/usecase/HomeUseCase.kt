package com.masterclass.vipingresso.features.home.usecase


import com.masterclass.vipingresso.features.home.repository.HomeRepository
import com.masterclass.vipingresso.utils.ResponseApi


class HomeUseCase {
    private val homeRepository = HomeRepository()

    suspend fun getEventSearch():ResponseApi {
        return homeRepository.getEventSearch()

    }

   suspend fun getAttractionSearch():ResponseApi{
        return homeRepository.getAttractionSearch()
    }
}