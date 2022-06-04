package com.one.githubusers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.one.githubusers.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.apply {
            setTitle("Detail")
            setDisplayHomeAsUpEnabled(true)
        }

        val user = intent.getParcelableExtra<User>(K.DETAIL_EXTRA) as User
        with(binding){
            tvName.text = user.name
            tvUsername.text = user.username
            tvRepository.text = user.repository
            tvFollowers.text = user.followers
            tvFollowing.text = user.following
            tvCompany.text = user.company
            tvLocation.text = user.location

            Glide.with(root)
                .load(user.avatar)
                .apply(RequestOptions().override(150,150))
                .into(binding.imgAvatar)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}