package com.masssive.opets.booking

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.masssive.opets.Groooming.BookingGromingKutuActivity
import com.masssive.opets.Penitipan.BookingPenitipanActivity
import com.masssive.opets.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class BookingFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_booking, container, false)

        // Gantilah ID sesuai dengan yang ada di layout XML
        val groomingImageView: ImageView = view.findViewById(R.id.grokut)
        val penitipanImageView: ImageView = view.findViewById(R.id.detcathot)

        groomingImageView.setOnClickListener {
            val intent = Intent(context, BookingGromingKutuActivity::class.java)
            startActivity(intent)
        }

        penitipanImageView.setOnClickListener{
            val intent = Intent(context, BookingPenitipanActivity ::class.java)
            startActivity(intent)
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BookingFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
