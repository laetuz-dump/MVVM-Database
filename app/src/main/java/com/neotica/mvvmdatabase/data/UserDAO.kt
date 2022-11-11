package com.neotica.mvvmdatabase.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    //Step 93: Add the @Update annotation
    @Update
    //Step 94: Create a new suspended function (Because Coroutines) and pass the Entity
    suspend fun updateUser(user: User)
    //Step 95: Open Repository Class

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>
}