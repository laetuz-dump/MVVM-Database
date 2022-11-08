package com.neotica.mvvmdatabase.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.neotica.mvvmdatabase.R
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //Step 11: Set/store inflatedLayout in the view variable.
        val view1 = inflater.inflate(R.layout.fragment_list, container, false)

        //Step 13: Use view1 to find the FAB and setOnClickListener.
        view1.floatingActionButton.setOnClickListener {
            //Step 14: Use NavHost Fragments to find NavController
            //Step 15: Navigate listFragment to addFragment
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        //Step 12 return view1
        return view1
    }
}