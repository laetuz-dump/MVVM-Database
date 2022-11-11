package com.neotica.mvvmdatabase.fragments.update

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.neotica.mvvmdatabase.R
import com.neotica.mvvmdatabase.data.User
import com.neotica.mvvmdatabase.data.UserViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*

class UpdateFragment : Fragment() {
    //Step 78: Create private val args and we want to use a property delegate to the navArgs
    //Step 79: Pass UpdateFragmentArgs
    private val args by navArgs<UpdateFragmentArgs>()
    //Step 88: Create ViewModel
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //Step 80: Put the inflater inside view3 variable.
        val view3 = inflater.inflate(R.layout.fragment_update, container, false)

        //Step 89: Initialize ViewModel, use ViewModelProvider
        //Step 90: Use get method and Get the data from our ViewModel class
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        //Step 82: Initialize and bind all necessary elements from fragment_update.xml to the database.
        view3.et_name.setText(args.currentUser.name)
        view3.et_age.setText(args.currentUser.age.toString())

        //Step 83: Set onClickListener to the button
        //Step 102: Insert updateItem() function
        view3.button.setOnClickListener { updateItem() }

        //Step 81: Return the inflater here
        return view3
    }

    //Step 84: Create a new function to update our item in the database
    private fun updateItem(){
        //Step 85: Create variables for name and age
        //To store the data from our fragment_update.xml
        val nameText = et_name.text.toString()
        val ageText = et_age.text.toString()

        //Step 87: Create inputCheck condition
        if (inputCheck(nameText, ageText)){
            //Create User Object
            //Step 91: Import User/Entity
            //Step 92: Use the previously created SafeArgs to safe the new data
            val updatedUser = User(args.currentUser.id,nameText,ageText.toInt())
            //Update Current User
            //Step 93: Open DAO class
            //Step 99: Call the ViewModel and use updateUser function,
            //then pass the updateUser from the ViewModel class.
            mUserViewModel.updateUser(updatedUser)
            //Step 100: Add back navigation to navigate back to the ListFragment
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
            Toast.makeText(requireContext(),"Database Updated.",Toast.LENGTH_SHORT).show()
        }//Step 101: Add else Toast
        else{
            Toast.makeText(requireContext(), "Please fill out all fields!", Toast.LENGTH_SHORT).show()}
    }

    //Step 86: Copy the inputText function from Add.Fragment.kt, step 30
    private fun inputCheck(nameText: String, ageText: String): Boolean{
        return !(TextUtils.isEmpty(nameText) && ageText.isEmpty())
    }

}