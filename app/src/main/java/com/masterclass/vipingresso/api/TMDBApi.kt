package com.masterclass.vipingresso.api


import com.masterclass.vipingresso.features.model.modelResultAttractionSearch.Classification
import com.masterclass.vipingresso.features.model.modelResultAttractionSearch.ResultAttractionSearch
import retrofit2.Response
import retrofit2.http.GET


interface TMDBApi {

    @GET("attractions.json")
    suspend fun getAttractionSearch(): Response<ResultAttractionSearch>

   // @GET("attractions.json?apikey=TzupjpmlqJr5RwoSVADZhLlALooF57dD")

}