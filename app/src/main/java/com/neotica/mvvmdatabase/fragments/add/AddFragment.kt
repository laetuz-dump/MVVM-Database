package com.neotica.mvvmdatabase.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.neotica.mvvmdatabase.R
import com.neotica.mvvmdatabase.data.User
import com.neotica.mvvmdatabase.data.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {
    //Step 26: Initialize ViewModel
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //Step 22: Set/store inflatedLayout in the view variable.
        val view2 = inflater.inflate(R.layout.fragment_add, container, false)

        //Step 27: Call mUserViewModel and use ViewModelProvider, add 'this' to context
        //Step 28: Use the get method to pass UserViewModel class
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        //Step 24: Find the id of the add button and setOnClickListener
        view2.button.setOnClickListener {
            //Step 25: Create new method of insertDataToDatabase() and create function
            insertDataToDatabase()
        }

        //Step 23: return view1
        return view2
    }

    private fun insertDataToDatabase() {
        //Step 29: Get text from the EditText
        val nameText = et_name.text.toString()
        val ageText = et_age.text.toString()

        //Step 31: Create condition if to check all inputCheck is true
        if (inputCheck(nameText,ageText)){
            //Step 32: If all inputCheck is true, then create User Object
            val user = User(0,nameText,Integer.parseInt(ageText))
            //Step 33: Add data to Database
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(),"Data added to the Database",Toast.LENGTH_SHORT).show()
            //Step 34: Navigate back to ListFragment
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        //Step 35: Create an else condition when the initial condition isn't met
        } else{Toast.makeText(requireContext(),"Please fill out all fields.",Toast.LENGTH_SHORT).show()}
    }

    //Step 30: Create inputCheck function to check if input is not null
    private fun inputCheck(nameText: String, ageText: String): Boolean{
        return !(TextUtils.isEmpty(nameText) && ageText.isEmpty())
    }

}