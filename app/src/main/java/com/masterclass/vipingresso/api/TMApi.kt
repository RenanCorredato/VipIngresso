package com.masterclass.vipingresso.api





import com.masterclass.vipingresso.features.model.EventSearchResult
import retrofit2.Response
import retrofit2.http.GET


interface TMApi {

    @GET("/discovery/v2/events?apikey=TzupjpmlqJr5RwoSVADZhLlALooF57dD")
    suspend fun getEventSearch(): Response<EventSearchResult>


}