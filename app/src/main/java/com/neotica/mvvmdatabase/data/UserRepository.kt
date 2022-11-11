package com.neotica.mvvmdatabase.data

import androidx.lifecycle.LiveData

class UserRepository (private val userDAO: UserDAO){
    val readAllData: LiveData<List<User>> = userDAO.readAllData()

    suspend fun addUser(user: User){
        userDAO.addUser(user)
    }

    //Step 95: Add a new suspended function, pass the Entity as the parameter
    suspend fun updateUser(user: User){
        //Step 96: Call Dao, use the updateUser function, pass user
        userDAO.updateUser(user)
    }

    //Step 97: Open ViewModel class

}