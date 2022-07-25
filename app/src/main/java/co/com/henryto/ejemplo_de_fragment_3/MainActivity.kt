package co.com.henryto.ejemplo_de_fragment_3

import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import co.com.henryto.ejemplo_de_fragment_3.databinding.ActivityMainBinding
import co.com.henryto.ejemplo_de_fragment_3.ui.Fragment3

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var btnOpenFragmentx: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnOpenFragmentx = binding.btnOpenFragmentx

        btnOpenFragmentx.setOnClickListener {
            var fragment3: Fragment3 = Fragment3() // creamos un objeto de tipo Fragment3 para luego
                            //usarlo como parametro de la función replaceFragment(xxxxx)
            replaceFragment(fragment3)}

        //--------------------------------------------------------------------------------------//
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        //--------------------------------------------------------------------------------------//
    }

    private fun loadFragment(fragment: Fragment) {
        //Esta función recibe un fragment que será el que queramos cargar en nuestro FrameLayout del
        // xml. Primero creamos el objeto fragmentTransaction a partir de la clase supportFragmentManager
        // que es el que se encarga de gestionar los fragments y posee la mayoría de los métodos que
        // necesitamos en la gestión.

        //Para cargar un fragment haremos siempre lo mismo, necesitamos avisar al sistema de que vamos
        // a hacer un cambio, añadirlo y guardar dicho cambio. Eso es exactamente lo que hace esta
        // función. Empezamos avisando del cambio con beginTransaction(), luego llamamos a la
        // función add() del fragmentTransaction para relacionar el fragment correspondiente y luego
        // cerramos con commit().

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.nav_host_fragment_activity_main, fragment)
        fragmentTransaction.commit()
    }

    private fun replaceFragment(fragment: Fragment){
        //Con la función loadFragmet, podemos añadir (cargar) fragments, pero si nos fijamos, cada
        // vez que añadimos uno, el anterior muere. Ahora pensemos que estamos realizando un flujo
        // de trabajo y son dos pantallas, en la primera el usuario tiene que introducir sus datos
        // personales y en la segunda su dirección. Cuando trabajamos con fragments tenemos la
        // posibilidad de emular el funcionamiento de las activities, es decir, podemos pulsar atrás
        // (tanto en la toolbar cómo el botón del móvil) y que vuelva al anterior.

        //Teniendo en cuenta lo anterior, la función replaceFragment ya no añade fragments, sino que
        // los reemplaza. Esta vez el objeto fragmentTransaction no llama a la función add(), sino a
        // replace(). Además, antes de hacer el commit(), hemos añadido addToBackStack(null), cono lo
        // que le decimos al sistema que nos permita ir para atrás.

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}