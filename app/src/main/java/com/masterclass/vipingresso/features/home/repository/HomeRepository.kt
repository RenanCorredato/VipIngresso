package com.masterclass.vipingresso.features.home.repository


import com.masterclass.vipingresso.api.ApiService
import com.masterclass.vipingresso.base.BaseRepository
import com.masterclass.vipingresso.utils.ResponseApi


class HomeRepository : BaseRepository() {

    suspend fun getAttractionSearch(): ResponseApi {
        return safeApiCall {
            ApiService.tmdbApi.getAttractionSearch()
        }
    }
}