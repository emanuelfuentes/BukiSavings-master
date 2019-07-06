package com.example.bukisavings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(),FragmentHelper {
    lateinit var args:HomeActivityArgs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        args = HomeActivityArgs.fromBundle(this.intent.extras!!)
        val navController = Navigation.findNavController(this,R.id.nav_host_fragment_home)
        setUpBottomNavMenu(navController)
    }

    override fun getUserId(): Long  = args.userId


    private fun setUpBottomNavMenu(navController: NavController) {
        bottom_nav?.let {
            NavigationUI.setupWithNavController(it, navController)
        }
    }

}
