package com.ddm.gallery_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ddm.gallery_test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        mainActivityViewModel.photosLiveData.observe(this, Observer {
            if(it!=null){
                binding.list.apply {
                    adapter = GalleryAdapter(this@MainActivity,it)
                    layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }
            else{
                Toast.makeText(this, "Error in getting data from api.", Toast.LENGTH_LONG).show()
            }
        })
        mainActivityViewModel.getPhotos()
    }
}