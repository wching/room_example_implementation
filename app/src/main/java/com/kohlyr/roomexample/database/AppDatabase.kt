package com.kohlyr.roomexample.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import com.kohlyr.roomexample.database.model.Room
import com.kohlyr.roomexample.database.model.Trip
import com.kohlyr.roomexample.database.utils.Converters

@Database(entities = [(Trip::class), (Room::class)], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun tripDao(): TripDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = android.arch.persistence.room.Room
                            .databaseBuilder(context.applicationContext,
                                    AppDatabase::class.java, "trips.db")
                            .allowMainThreadQueries()
                            .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}
