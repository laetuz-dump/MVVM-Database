package com.neotica.mvvmdatabase.data

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Query(value = "SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>
}