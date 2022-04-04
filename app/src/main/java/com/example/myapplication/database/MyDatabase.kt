package com.example.myapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.data.Student

@Database(entities = [Student::class], version = 1)
abstract class MyDatabase: RoomDatabase() {
    abstract fun studentDao(): StudentDao

    companion object{

        @Volatile
        private var INSTANCE: MyDatabase? = null

        fun getInstance(context: Context): MyDatabase?{
            if (INSTANCE == null){
                synchronized(MyDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext
                        , MyDatabase::class.java, "mydatabase.db").build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance(){
            INSTANCE = null
        }

    }


}