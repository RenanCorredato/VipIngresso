package com.masterclass.vipingresso.api





import com.masterclass.vipingresso.features.model.modelAttractionSearch.AttractionSearchResult
import com.masterclass.vipingresso.features.model.modelEventSearch.EventSearchResult
import retrofit2.Response
import retrofit2.http.GET


interface TMApi {

    @GET("/discovery/v2/events?apikey=TzupjpmlqJr5RwoSVADZhLlALooF57dD")
    suspend fun getEventSearch(): Response<EventSearchResult>

    @GET("/discovery/v2/attractions?apikey=TzupjpmlqJr5RwoSVADZhLlALooF57dD")
    suspend fun getAttractionSearch(): Response<AttractionSearchResult>


}