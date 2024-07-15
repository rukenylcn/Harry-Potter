package com.bandirma.harrypotter

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object RetrofitClient {
    const val baseUrl = "https://api.potterdb.com/"

    fun getRetrofit(): Retrofit{
        var retrofit = Retrofit
            .Builder()
            .addConverterFactory(ScalarsConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
        return retrofit
    }
}