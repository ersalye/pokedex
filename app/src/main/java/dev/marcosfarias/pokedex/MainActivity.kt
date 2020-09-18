package dev.marcosfarias.pokedex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//    private var currentNavController: LiveData<NavController>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        if (savedInstanceState == null) {
//            setupBottomNavigationBar()
//        }
        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
//        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)
//
//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        val navController = navHostFragment.navController
//        val appBarConfiguration = AppBarConfiguration(setOf(
//            R.id.navigation_pokedex, R.id.navigation_moves, R.id.navigation_itens))
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)
    }

//    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
//        super.onRestoreInstanceState(savedInstanceState)
//
//        setupBottomNavigationBar()
//    }
        private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
                val navHostFragment =
                    supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
                val navController: NavController = navHostFragment.navController
                when (menuItem.itemId) {
                    R.id.pokedex -> {
                        navController.navigate(R.id.action_to_pokedexFragment)
                        return@OnNavigationItemSelectedListener true
                    }

                    R.id.moves -> {
                        navController.navigate(R.id.action_to_movesFragment)
                        return@OnNavigationItemSelectedListener true
                    }

                    R.id.items -> {
                        navController.navigate(R.id.action_to_itemsFragment)
                        return@OnNavigationItemSelectedListener true
                    }
                }
                false
        }

//    private fun setupBottomNavigationBar() {
//        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
//        val navGraphIds = listOf(R.navigation.pokemon,R.navigation.moves)
//
//        // Setup the bottom navigation view with a list of navigation graphs
//        val controller = bottomNavigationView.setupWithNavController(
//            navGraphIds = navGraphIds,
//            fragmentManager = supportFragmentManager,
//            containerId = R.id.nav_host_fragment,
//            intent = intent
//        )
//
//        // Whenever the selected controller changes, setup the action bar.
//        controller.observe(this, Observer { navController ->
//            setupActionBarWithNavController(navController)
//        })
//        currentNavController = controller
//    }
//
//    override fun onSupportNavigateUp(): Boolean {
//        return currentNavController?.value?.navigateUp() ?: false
//    }
}
