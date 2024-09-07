package com.dicoding.submissionfinal

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html

class AboutActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        val actionBar = supportActionBar
//        actionBar?.title = "Profile"
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#009688")))
        supportActionBar!!.setTitle(Html.fromHtml("<font color=\"white\">Profile</font>"))

    }
}