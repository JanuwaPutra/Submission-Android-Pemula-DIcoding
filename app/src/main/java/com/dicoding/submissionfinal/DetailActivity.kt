package com.dicoding.submissionfinal

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    companion object {
        const val key_cat = "key_cat"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#009688")))

        val btnShare = findViewById<Button>(R.id.btnShare)



        val  tvDetailDescription: TextView = findViewById(R.id.tv_detail_description)
        val tvDetailName: TextView = findViewById(R.id.tv_detail_name)
        val ivDetailPhoto: ImageView = findViewById(R.id.iv_detail_photo)

        supportActionBar!!.setTitle(Html.fromHtml("<font color=\"white\">Detail</font>"))


        val dataCat = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Cat>(key_cat, Cat::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Cat>(key_cat)
        }
        if (dataCat != null) {
            tvDetailDescription.text = dataCat.description
            ivDetailPhoto.setImageResource(dataCat.photo)
            tvDetailName.text = dataCat.name
        }
        btnShare.setOnClickListener {
            val linkToShare = "https://www.ruparupa.com/blog/jenis-kucing-peliharaan/" // Ganti dengan tautan/link yang ingin Anda bagikan

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, linkToShare)

            startActivity(Intent.createChooser(intent, "Bagikan tautan melalui"))
        }

    }
}