import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.masssive.opets.Tambahan.KebijakanActivity
import com.masssive.opets.R
import com.masssive.opets.Tambahan.KetentuanPenggunaActivity
import com.masssive.opets.Tambahan.TentangKamiActivity
import com.masssive.opets.profile.ProfileKamuActivity

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ProfileFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // Menangani klik pada ImageView dengan ID ic_right_2
        val icRight2: ImageView = view.findViewById(R.id.ic_right_2)
        icRight2.setOnClickListener {
            // Memulai aktivitas KebijakanActivity ketika ImageView diklik
            val intent = Intent(context, KebijakanActivity::class.java)
            startActivity(intent)
        }
        val ic_right_1: ImageView = view.findViewById(R.id.ic_right_1)
        ic_right_1.setOnClickListener{
            val intent = Intent(context,ProfileKamuActivity::class.java)
            startActivity(intent)
        }
        val ic_right_6: ImageView = view.findViewById(R.id.ic_right_6)
        ic_right_6.setOnClickListener{
            val inten = Intent(context, KetentuanPenggunaActivity::class.java)
            startActivity(inten)
        }
        val ic_right_5: ImageView = view.findViewById(R.id.ic_right_5)
        ic_right_5.setOnClickListener{
            val intent = Intent(context, TentangKamiActivity::class.java)
            startActivity(intent)
        }

        val ic_right_7: ImageView = view.findViewById(R.id.ic_right_7)
        ic_right_7.setOnClickListener{
            showExitConfirmationDialog()
        }

        return view
    }

    private fun showExitConfirmationDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Konfirmasi")
            .setMessage("Apakah Anda yakin ingin menutup aplikasi?")
            .setPositiveButton("Ya") { _, _ ->
                // Tindakan ketika pengguna memilih "Ya" (tutup aplikasi)
                activity?.finish()
            }
            .setNegativeButton("Tidak") { dialog, _ ->
                // Tindakan ketika pengguna memilih "Tidak" (tutup dialog)
                dialog.dismiss()
            }
            .show()
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
