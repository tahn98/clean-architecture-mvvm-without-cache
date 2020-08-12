package com.example.cleanarcdemo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cleanarcdemo.data.Plant

@Database(entities = [Plant::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun plantDao() : PlantDao

//    companion object {
//        @Volatile private var instance : AppDatabase? = null
//
//        fun getInstance(ctx : Context): AppDatabase =
//            instance ?: synchronized(this){
//                instance ?: buildDatabase(ctx).also { instance = it }
//            }
//
//        private fun buildDatabase(context: Context): AppDatabase {
//            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME).build()
//        }
//    }
}

private const val DATABASE_NAME = "sunflower-db"