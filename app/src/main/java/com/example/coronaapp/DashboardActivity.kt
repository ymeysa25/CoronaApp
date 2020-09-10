package com.example.coronaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)


        corona.setOnClickListener(){
            intent = Intent(this, CoronaActivity::class.java)
            startActivity(intent)
        }

        about.setOnClickListener(){
            intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }
    }
}
