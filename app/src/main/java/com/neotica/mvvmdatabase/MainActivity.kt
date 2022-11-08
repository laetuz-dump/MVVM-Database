package com.neotica.mvvmdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Step 16: Use method setupActionBarWithNavController
        //Step 17: Pass findNavController as a parameter
        //Step 18: Pass the id of NavHostFragment
        setupActionBarWithNavController(findNavController(R.id.fragmentContainerView))
    }

    //Step 19: Override onSupportNavigateUp to use the back button on the action bar.
    override fun onSupportNavigateUp(): Boolean {
        //Step 20: Create NavController object and specify fragment
        val navController = findNavController(R.id.fragmentContainerView)
        //Step 21: Return NavController NavigateUp
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}