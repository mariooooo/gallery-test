package com.ddm.gallery_test

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkService {
    private val client: OkHttpClient = OkHttpClient
        .Builder()
        .build()

    fun retrofitService(): ApiMain {
        return Retrofit.Builder()
            .baseUrl("https://api.unsplash.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(ApiMain::class.java)
    }
}