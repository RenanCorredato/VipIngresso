package com.masterclass.vipingresso.features.attractiondetails.respository

import com.masterclass.vipingresso.api.ApiService
import com.masterclass.vipingresso.base.BaseRepository
import com.masterclass.vipingresso.utils.ResponseApi

class DetailRepository:BaseRepository() {


  suspend  fun getAttractionDetailsId(movieId: Int):ResponseApi {
         return  safeApiCall {
                ApiService.tmdbApi.getAttractionDetailsId(movieId)
            }
    }
}