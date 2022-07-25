package co.com.henryto.ejemplo_de_fragment_3.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import co.com.henryto.ejemplo_de_fragment_3.R
import co.com.henryto.ejemplo_de_fragment_3.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() { //Un Fragment extiende de Fragment() y no de una Activity

    private var _binding: FragmentNotificationsBinding? = null  //implementacion de binging en un fragment

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!  //implementacion de binging en un fragment

    override fun onCreateView(   // onCreateView se refiere a una vista y no a una actividad por tanto la
                                // forma de tratar las cosas es un poco diferente
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root    // todos los elenetos del xml correspondientes a este
                        // fragment vienen de root (que es de tipo View), por ejemplo elementos
                        // botones, campos de texto etc. La variable root es quien tiene el contexto.

        val textView: TextView = binding.textNotifications // ejemplo con binding
        val textView2: TextView = root.findViewById(R.id.text_notifications) //ejemplo sin binding

        notificationsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}