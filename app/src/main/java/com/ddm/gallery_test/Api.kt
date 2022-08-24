package com.ddm.gallery_test

import retrofit2.Call
import retrofit2.http.GET

interface ApiMain {
    @GET("photos/?client_id=ab3411e4ac868c2646c0ed488dfd919ef612b04c264f3374c97fff98ed253dc9")
    fun getPhotos(): Call<List<Photo>>

}