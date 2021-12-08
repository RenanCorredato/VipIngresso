package com.masterclass.vipingresso.features.home.usecase


import com.masterclass.vipingresso.extensions.getFullImageUrl
import com.masterclass.vipingresso.features.home.repository.HomeRepository
import com.masterclass.vipingresso.features.model.modelResultAttractionSearch.ResultAttractionSearch
import com.masterclass.vipingresso.features.model.teste.model.NowPlaying
import com.masterclass.vipingresso.utils.ResponseApi


class HomeUseCase {

    private val homeRepository = HomeRepository()


    suspend fun getAttractionSearch(): ResponseApi {
        return when (val responseApi = homeRepository.getAttractionSearch()) {
            is ResponseApi.Success -> {
                val data = responseApi.data as? NowPlaying
                val result = data?.results?.map {
                    it.backdrop_path = it.backdrop_path.getFullImageUrl()
                    it.poster_path = it.poster_path.getFullImageUrl()
                    it
                }
                ResponseApi.Success(result)
            }
            is ResponseApi.Error -> {
                responseApi
            }
        }

    }

   suspend fun getAttractionDetailsId(id: Int) =
            homeRepository.getAttractionDetailsId(id)


}




