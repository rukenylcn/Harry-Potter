package com.bandirma.harrypotter


import retrofit2.Call
import retrofit2.http.GET

interface HarryPotterDbService {

    @GET("vl/books")
    fun GetBookList(): Call<String>
}