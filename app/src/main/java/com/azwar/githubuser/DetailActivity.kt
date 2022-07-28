package com.azwar.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar!!.title = intent.getStringExtra("intent_title" )

        val user = intent.getParcelableExtra<User>("extra_user")

        val ivProfile: ImageView = findViewById(R.id.iv_profile)
        val tvName: TextView = findViewById(R.id.tv_name)
        val tvUsername: TextView = findViewById(R.id.tv_username)
        val tvFollowers: TextView = findViewById(R.id.tv_followers)
        val tvFollowing: TextView = findViewById(R.id.tv_following)
        val tvRepository: TextView = findViewById(R.id.tv_repository)
        val tvLocation: TextView = findViewById(R.id.tv_location)
        val tvCompany: TextView = findViewById(R.id.tv_company)

        if (user != null) {
            ivProfile.setImageResource(user.avatar)
        }
        tvName.text = user?.name.toString()
        tvUsername.text = '@'+user?.username.toString()
        tvFollowers.text = user?.followers.toString()+" Followers"
        tvFollowing.text = user?.following.toString()+" Following"
        tvRepository.text = user?.repository.toString()+" Repository"
        tvLocation.text = "Location: "+user?.location.toString()
        tvCompany.text = "Company: "+user?.company.toString()

    }
}