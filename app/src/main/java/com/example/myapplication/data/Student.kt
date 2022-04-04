package com.example.myapplication.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Student(
    @PrimaryKey(autoGenerate = true) var id: Int?,
    var nama: String,
    var email: String 
): Parcelable
