package com.masterclass.vipingresso.features.attractiondetails.usecase

import com.masterclass.vipingresso.extensions.getFullImageUrl
import com.masterclass.vipingresso.features.attractiondetails.respository.DetailRepository
import com.masterclass.vipingresso.features.model.teste.model.Movie
import com.masterclass.vipingresso.features.model.teste.model.NowPlaying
import com.masterclass.vipingresso.utils.ResponseApi

class DetailUseCase {

    private val detailRespository = DetailRepository()

   suspend fun getAttractionDetailsId(movieId: Int):ResponseApi {
       return when (val responseApi = detailRespository.getAttractionDetailsId(movieId)) {
           is ResponseApi.Success -> {
               val data = responseApi.data as? Movie
                   data?.backdrop_path = data?.backdrop_path?.getFullImageUrl()
               return ResponseApi.Success(data)
           }
           is ResponseApi.Error -> {
               responseApi
           }
       }

   }
}
