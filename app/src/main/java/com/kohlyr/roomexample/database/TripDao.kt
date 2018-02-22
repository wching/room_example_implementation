package com.kohlyr.roomexample.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.IGNORE
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import com.kohlyr.roomexample.database.model.Room
import com.kohlyr.roomexample.database.model.Trip


@Dao
interface TripDao {

	@Query("SELECT * FROM trips")
	fun getAll(): List<Trip>

	@Insert(onConflict = IGNORE)
	fun insert(trip: Trip)

	@Insert(onConflict = IGNORE)
	fun insertAll(trips: List<Trip>)

	@Update(onConflict = REPLACE)
	fun update(trip: Trip)

	@Delete
	fun delete(trip: Trip)

	@Insert(onConflict = IGNORE)
	fun insert(room: Room)

	// INSERT INTO Users(id, weight, desiredWeight) VALUES(1, 160, 145);
	@Query("INSERT INTO room(tripId, number_of_adults, children_ages) VALUES ()")
	fun insertRoom(room: Room, tripId: Long)
}
