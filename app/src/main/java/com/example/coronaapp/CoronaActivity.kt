package com.example.coronaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CoronaActivity : AppCompatActivity() {

    private lateinit var rvItem : RecyclerView
    private var list : ArrayList<Corona> = arrayListOf()
    private var title: String = "Mode List"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_corona)
        setActionBarTitle(title)

        rvItem = findViewById(R.id.rv_item)
        rvItem.setHasFixedSize(true)


        list.addAll(CoronaData.listData)
//        showRecyclerList()
        showRecyclerList()

    }

    private fun showRecyclerList(){
        rvItem.layoutManager = LinearLayoutManager(this )

        val listAdapter = ListAdapter(list)
        rvItem.adapter = listAdapter
    }

    private fun showRecyclerCardView() {
        rvItem.layoutManager = LinearLayoutManager(this)
        val cardViewHeroAdapter = CardViewAdapter(list)
        rvItem.adapter = cardViewHeroAdapter
    }

    // Create menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                title = "Mode List"
                showRecyclerList()

            }
            R.id.action_cardview -> {
                title = "Mode CardView"
                showRecyclerCardView()
            }
        }

        setActionBarTitle(title)
    }

    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = title
        }
    }
}
