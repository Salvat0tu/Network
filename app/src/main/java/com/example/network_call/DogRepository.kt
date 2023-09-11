package com.example.network_call

import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object DogRepository {

    var endoPoint: EndoPoint? = null

    suspend fun getImage(): Response<DogImg>? {
        if (endoPoint == null) {
            endoPoint = createRetrofitInstance().create(EndoPoint::class.java)
        }
        return endoPoint?.getImage()
    }

    private fun createRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS).build()
            ).build()

    }

}