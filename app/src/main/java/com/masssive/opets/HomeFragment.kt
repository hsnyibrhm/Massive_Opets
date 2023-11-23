package com.masssive.opets

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.masssive.opets.adapter.ListDiskonAdapter
import com.masssive.opets.adapter.ListPriviewAdapter
import com.masssive.opets.model.Preview
import com.masssive.opets.model.diskon

class
HomeFragment : Fragment() {

    private lateinit var rvDiskon: RecyclerView
    private lateinit var rvPriview: RecyclerView
    private val listt = ArrayList<Preview>()
    private val list = ArrayList<diskon>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Initialize RecyclerView here
        rvDiskon = view.findViewById(R.id.rv_dis)
        rvDiskon.setHasFixedSize(true)

        rvPriview = view.findViewById(R.id.recyclerView)
        rvPriview.setHasFixedSize(true)

        // Populate the list and show RecyclerView
        list.addAll(getListDiskon())
        listt.addAll(getLisPreview())
        showRecyclerList()

        val ivVit1: ImageView = view.findViewById(R.id.iv_vit1)
        ivVit1.setOnClickListener {
            // Start PenitipanActivity when ImageView is clicked
            val intent = Intent(context, PenitipanActivity::class.java)
            startActivity(intent)
        }

        val ivVit2 = view.findViewById<ImageView>(R.id.iv_vit2)
        ivVit2.setOnClickListener {
            // Navigate to  or perform any action you desire
            startActivity(Intent(activity, GroomingActivity::class.java))
        }


        return view
    }

    private fun getLisPreview(): Collection<Preview> {
        val dataPv = resources.obtainTypedArray(R.array.priv_foto)
        val tgl = resources.getStringArray(R.array.tgl_priv)
        val listpriview = ArrayList<Preview>()

        for (i in tgl.indices){
            val priview = Preview(dataPv.getResourceId(i, -1), " ", tgl[i] )
            listpriview.add(priview)
        }
        dataPv.recycle()
        return listpriview

    }

    private fun showRecyclerList() {
        // Use context instead of 'this' in LinearLayoutManager
        rvPriview.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val listPriviewAdapter = ListPriviewAdapter(listt)
        rvPriview.adapter = listPriviewAdapter

        rvDiskon.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val listDiskonAdapter = ListDiskonAdapter(list)
        rvDiskon.adapter = listDiskonAdapter
    }

    private fun getListDiskon(): ArrayList<diskon> {
        val dataPhotoD = resources.obtainTypedArray(R.array.Dis_foto)
        val dataNameD = resources.getStringArray(R.array.dataD_name)
        val listDiskon = ArrayList<diskon>()

        for (i in dataNameD.indices) {
            val diskon = diskon(dataPhotoD.getResourceId(i, -1), dataNameD[i])
            listDiskon.add(diskon)
        }

        // Release the resources when done
        dataPhotoD.recycle()

        return listDiskon
    }



}
