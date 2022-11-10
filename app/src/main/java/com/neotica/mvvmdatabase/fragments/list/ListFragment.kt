package com.neotica.mvvmdatabase.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.neotica.mvvmdatabase.R
import com.neotica.mvvmdatabase.data.UserViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListFragment : Fragment() {
    //Step 54
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //Step 11: Set/store inflatedLayout in the view variable.
        val view1 = inflater.inflate(R.layout.fragment_list, container, false)

        //RecyclerView
        //Step 55: Add recyclerView to the inflated view
        val recyclerView = view1.recView
        //Step 56: Create adapter variable on listAdapter
        val adapter = ListAdapter()
        //Step 57: Set adapter for the recyclerView
        recyclerView.adapter = adapter
        //Step 58: Set layoutManager  to linear layoutManager, set requireContext
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //UserViewModel
        //Step 59: Initialize UserViewModel, use ViewModelProvider
        //Step 60: Pass the context to this class and get the context from  UserViewModel.kt
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        //Step 61: readAllData from listview using Observer
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer {
            user ->
            adapter.setData(user)
        })

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