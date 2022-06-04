package com.one.githubusers

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.one.githubusers.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this)
            .load(R.drawable.gusers)
            .into(binding.imgSplash)

        Handler(Looper.getMainLooper()).postDelayed({
            val activeIntent = Intent(this, MainActivity::class.java)
            startActivity(activeIntent)
            finish()
        },3000)
    }
}