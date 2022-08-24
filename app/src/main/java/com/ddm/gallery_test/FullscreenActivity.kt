package com.ddm.gallery_test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.Target
import com.ddm.gallery_test.databinding.FullscreenBinding

class FullscreenActivity: AppCompatActivity()  {
    private lateinit var binding: FullscreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FullscreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val fullsiezeUrl: String? = intent.extras!!.getString("fullsize_url")
        Glide.with(this)
            .load(fullsiezeUrl)
            .override(Target.SIZE_ORIGINAL)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .fallback(R.drawable.ic_launcher_background)
            .into(binding.photo)
    }
}