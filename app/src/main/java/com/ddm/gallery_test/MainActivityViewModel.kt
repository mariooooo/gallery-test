package com.ddm.gallery_test

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Response

class MainActivityViewModel : ViewModel() {
    var api: ApiMain = NetworkService.retrofitService()
    val photosLiveData = MutableLiveData<List<Photo>>()
    fun getPhotos() {
        val call = api.getPhotos()
        call.enqueue(object : retrofit2.Callback<List<Photo>> {
            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                if (response.isSuccessful) {
                    photosLiveData.postValue(response.body())
                } else {
                    photosLiveData.postValue(null)
                }
            }

            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                println("ex")
                photosLiveData.postValue(null)
            }
        })
    }
}