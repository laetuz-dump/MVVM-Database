package com.neotica.mvvmdatabase.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

//Step 66: Parcelize Entity by adding @Parcelize annotation
@Parcelize
@Entity(tableName = "user_table")
data class User (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val age: Int
    //Step 67: Extends Parcelable
    ):Parcelable