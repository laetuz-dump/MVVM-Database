package com.neotica.mvvmdatabase.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.neotica.mvvmdatabase.R
import com.neotica.mvvmdatabase.data.User
import kotlinx.android.synthetic.main.custom_row.view.*

//Step 39: Create a recyclerView adapter class

//Step 40: Extends to RecyclerView.Adapter
//Step 45: Implement Members
class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    //Step 46: Create a new variable named userList to lists our users
    //Step 47: Create emptyList as an expression to userList variable and pass User
    private var userList = emptyList<User>()

    //Step 41: Create MyViewHolder class inside the ListAdapter class.
    //Step 42: Extends it to RecyclerView.ViewHolder
    //Step 43: Create a new parameter of (itemView: View) to pass the View into ViewHolder
    //Step 44: Call the View parameter again inside RecyclerView.ViewHolder
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //Step 48: Return MyViewHolder
        //Step 49: Pass the custom_row.xml LayoutInflater as the View
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //Step 51: Create variable currentItem, to show item Position
        val currentItem = userList[position]
        //Step 52: Use holder to get every item position from userList for currentItem
        holder.itemView.keyText.text = currentItem.id.toString()
        holder.itemView.nameText.text = currentItem.name
        holder.itemView.ageText.text = currentItem.age.toString()

        //Step 71: Add Item Holder for rowLayout
        //Step 72: Add a setOnClickListener{}
        holder.itemView.rowLayout.setOnClickListener {
            //Step 73: Add action variable inside the setOnClickListener
            //Step 74: Use the ListFragmentDirections,
            //Step 75: Add actionListFragmentToUpdateFragment and pass currentItem
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            //Step 76: Add Item Holder for findNavController
            //Step 77: Navigate and pass to action
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        //Step 50: Return size of this list
        return userList.size
    }

    //Step 53: Create setData function to set the userList with the value which will be passed in the parameter
    //In this project, the value was passed from our entity class: User.kt
    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()
    }
}