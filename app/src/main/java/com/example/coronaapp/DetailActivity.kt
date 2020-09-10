package com.example.coronaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_detail2.*
import kotlin.reflect.typeOf

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail2)

        val bundle:Bundle? = intent.extras
        val position = bundle!!.getInt("position")

        val coronaData = CoronaData
        var listCorona = coronaData.listData

        val corona = listCorona[position]
        Glide.with(this)
            .load(corona.photo)
            .apply(RequestOptions().override(350, 550))
            .into(img_item_photo)

        tv_item_name.text = corona.name
        tv_item_total.text = "Total Kasus : " + corona.total.toString()
        tv_item_death.text = "Meninggal   : " + corona.death.toString()
        tv_item_recoveries.text = "Sembuh      : " + corona.recoveries.toString()


        //action bar
        val actionBar = supportActionBar
        //set action bar title
        actionBar!!.title = "Corona di " + corona.name

        //set back button
        actionBar.setDisplayHomeAsUpEnabled(true)
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
