package com.masssive.opets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.opets.ListDiskonAdapter
import com.example.opets.diskon

class MainActivity : AppCompatActivity() {
    private lateinit var rvDiskon: RecyclerView
    private val list =ArrayList<diskon>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvDiskon = findViewById(R.id.rv_dis)
        rvDiskon.setHasFixedSize(true)

        list.addAll(getListiskon())
        showRecyclerList()
    }
    private fun showRecyclerList() {
        rvDiskon.layoutManager = LinearLayoutManager(this)
        val listDiskonAdapter = ListDiskonAdapter(list)
        rvDiskon.adapter = listDiskonAdapter
    }

    private fun getListiskon(): ArrayList<diskon> {
        val dataPhotoD = resources.obtainTypedArray(R.array.Dis_foto)
        val dataNameD = resources.getStringArray(R.array.dataD_name)
        val listDiskon = ArrayList<diskon>()
        for (i in dataNameD.indices){
            val diskon = diskon(dataPhotoD.getResourceId(i, -1), dataNameD[i])
            listDiskon.add(diskon)

        }
        return listDiskon
    }
}