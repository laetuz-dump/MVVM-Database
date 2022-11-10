package com.neotica.mvvmdatabase.fragments.update

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.neotica.mvvmdatabase.R
import kotlinx.android.synthetic.main.fragment_update.view.*

class UpdateFragment : Fragment() {
    //Step 78: Create private val args and we want to use a property delegate to the navArgs
    //Step 79: Pass UpdateFragmentArgs
    private val args by navArgs<UpdateFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //Step 80: Put the inflater inside view3 variable.
        val view3 = inflater.inflate(R.layout.fragment_update, container, false)

        //Step 82: Initialize and bind all necessary elements from fragment_update.xml to the database.
        view3.et_name.setText(args.currentUser.name)
        view3.et_age.setText(args.currentUser.age.toString())

        //Step 81: Return the inflater here
        return view3
    }

}