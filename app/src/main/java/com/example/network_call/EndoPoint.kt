package com.example.network_call

import retrofit2.Response
import retrofit2.http.GET

interface EndoPoint {

    @GET("breeds/image/random")
    suspend fun getImage(): Response<DogImg>
}