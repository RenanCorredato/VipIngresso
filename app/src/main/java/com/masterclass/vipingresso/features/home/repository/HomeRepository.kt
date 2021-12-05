package com.masterclass.vipingresso.features.home.repository

import com.masterclass.vipingresso.api.ApiService
import com.masterclass.vipingresso.base.BaseRepository
import com.masterclass.vipingresso.utils.ResponseApi

class HomeRepository:BaseRepository() {



    suspend fun getEventSearch(): ResponseApi {
        return safeApiCall {
            ApiService.tmApi.getEventSearch()
        }

    }

   suspend fun getAttractionSearch():ResponseApi {
        return safeApiCall {
            ApiService.tmApi.getAttractionSearch()
        }
    }
}