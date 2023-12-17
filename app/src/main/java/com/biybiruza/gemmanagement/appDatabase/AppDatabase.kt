package com.biybiruza.gemmanagement.appDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.biybiruza.gemmanagement.dao.UserDao
import com.biybiruza.gemmanagement.entities.Users

@Database(entities = [Users::class], version = 2)

abstract class AppDatabase : RoomDatabase() {

    abstract fun usersDao(): UserDao

    companion object {

        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                instance =
                    Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        "users_db"
                    )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }
    }
}