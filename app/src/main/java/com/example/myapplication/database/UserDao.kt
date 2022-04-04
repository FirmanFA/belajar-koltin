package com.example.myapplication.database

import androidx.room.*
import com.example.myapplication.data.Student
import com.example.myapplication.data.User

@Dao
interface UserDao {

    @Query("SELECT * FROM User WHERE username = :username")
    fun login(username: String):User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User):Long

}