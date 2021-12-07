package com.masterclass.vipingresso.api


import com.masterclass.vipingresso.BuildConfig
import com.masterclass.vipingresso.utils.ConstantsApp.Api.API_TOKEN
import com.masterclass.vipingresso.utils.ConstantsApp.Api.API_TOKEN_KEY
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiService {

    val tmdbApi: TMDBApi = getTMDBApiClient().create(TMDBApi::class.java)

    fun getTMDBApiClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://app.ticketmaster.com/discovery/v2/")
            .client(getInterceptorClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getInterceptorClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }

        val interceptor = OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .addInterceptor { chain ->
                val url = chain.request().url.newBuilder()
                    .addQueryParameter(API_TOKEN_KEY, API_TOKEN)

                    .build()
                val newRequest = chain.request().newBuilder().url(url).build()
                chain.proceed(newRequest)
            }
        return interceptor.build()
    }
}