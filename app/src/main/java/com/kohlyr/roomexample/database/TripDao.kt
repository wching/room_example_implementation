package com.kohlyr.roomexample.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.IGNORE
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import com.kohlyr.roomexample.database.model.Trip


@Dao
interface TripDao {

    @Query("SELECT * FROM trip")
    fun getAll(): ArrayList<Trip>

    @Insert(onConflict = IGNORE)
    fun insert(trip: Trip)

    @Insert(onConflict = IGNORE)
    fun insertAll(trips: ArrayList<Trip>)

    @Update(onConflict = REPLACE)
    fun update(trip: Trip)

    @Delete
    fun delete(trip: Trip)
}
