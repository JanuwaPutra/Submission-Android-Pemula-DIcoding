package com.dicoding.submissionfinal

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvCat: RecyclerView
    private val list = ArrayList<Cat>()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val actionBar = supportActionBar
//        actionBar?.title = "Cat Lovers"
        rvCat = findViewById(R.id.rv_cat)
        rvCat.setHasFixedSize(true)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#009688")))
        supportActionBar!!.setTitle(Html.fromHtml("<font color=\"white\">Cat Lovers</font>"))
        list.addAll(getListCat())
        showRecyclerList()


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.about_me -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }


    private fun getListCat(): ArrayList<Cat> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listCat = ArrayList<Cat>()
        for (i in dataName.indices) {
            val cat = Cat(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listCat.add(cat)
        }
        return listCat
    }

    private fun showRecyclerList() {
        rvCat.layoutManager = LinearLayoutManager(this)
        val listCatAdapter = ListCatAdapter(list)
        rvCat.adapter = listCatAdapter
//        listHeroAdapter.setOnItemClickCallback(object : ListHeroAdapter.OnItemClickCallback {
//            override fun onItemClicked(data: Hero) {
//                showSelectedHero(data)
//            }
//        })
    }
}

//        private fun showSelectedHero(hero: Hero) {
//        Toast.makeText(this, "Kamu memilih " + hero.name, Toast.LENGTH_SHORT).show()
//    }


