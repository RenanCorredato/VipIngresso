package com.masterclass.vipingresso.api



import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiService {

    val tmApi: TMApi = getTMDBApiClient().create(TMApi::class.java)

    fun getTMDBApiClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://app.ticketmaster.com/discovery/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

//    private fun getInterceptorClient(): OkHttpClient {
//        val loggingInterceptor = HttpLoggingInterceptor()
//        if (BuildConfig.DEBUG) {
//            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
//        }
//
//        val interceptor = OkHttpClient.Builder()
//            .connectTimeout(5, TimeUnit.SECONDS)
//            .readTimeout(10, TimeUnit.SECONDS)
//            .writeTimeout(10, TimeUnit.SECONDS)
//            .addInterceptor(loggingInterceptor)
//            .addInterceptor { chain ->
//                val url = chain.request().url.newBuilder()
//                    .addQueryParameter(API_TOKEN_KEY, API_TOKEN)
//                    .addQueryParameter(QUERY_PARAM_LANGUAGE_KEY, QUERY_PARAM_LANGUAGE_VALUE)
//                    .build()
//                val newRequest = chain.request().newBuilder().url(url).build()
//                chain.proceed(newRequest)
//            }
//        return interceptor.build()
//    }
}