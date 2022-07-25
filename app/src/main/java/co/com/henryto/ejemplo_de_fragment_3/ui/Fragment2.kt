package co.com.henryto.ejemplo_de_fragment_3.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import co.com.henryto.ejemplo_de_fragment_3.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Fragment2 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private lateinit var btn1: Button

    override fun onCreateView(  //este metodo es cuando la vista del fragment ya ha sido inflada
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var root: View = inflater.inflate(R.layout.fragment_2, container, false)
        // todos los elemetos del xml correspondientes a este
        // fragment vienen de root (que es de tipo View), por ejemplo elementos
        // botones, campos de texto etc. La variable root es quien tiene el contexto.

        btn1 = root.findViewById(R.id.btn1)

        btn1.setOnClickListener {
            Toast.makeText(root.context, "Has presionado el Button 1 que abre el Fragment 3",
                Toast.LENGTH_LONG).show()
        }
        return root
    }
}