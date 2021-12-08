package com.masterclass.vipingresso.api



import com.masterclass.vipingresso.features.model.teste.model.NowPlaying
import com.masterclass.vipingresso.features.model.modelResultAttractionDetails.ResultAttractionDetails
import com.masterclass.vipingresso.features.model.teste.model.Movie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface TMDBApi {

    @GET("movie/now_playing")
    suspend fun getAttractionSearch(): Response<NowPlaying>

    @GET("movie/{movie_id}")
    suspend fun getAttractionDetailsId(
        @Path("movie_id") movieId: Int
    ): Response<Movie>


}