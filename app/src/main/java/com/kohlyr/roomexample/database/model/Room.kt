package com.kohlyr.roomexample.database.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import android.os.Parcelable
import com.kohlyr.roomexample.database.utils.Converters
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(
		tableName = "rooms",
		indices = [(Index(value = ["tripId"]))],
		foreignKeys = [(ForeignKey(
				entity = Trip::class,
				parentColumns = arrayOf("id"),
				childColumns = arrayOf("tripId"),
				onDelete = ForeignKey.CASCADE))])
data class Room(

		@PrimaryKey(autoGenerate = true)
		var id: Long = 0,

		@ColumnInfo(name = "tripId")
		var mTripId: String = "",

		@ColumnInfo(name = "number_of_adults")
		var mAdults: Int = 2,

		@ColumnInfo(name = "children_ages")
		@TypeConverters(Converters::class)
		var mChildrenAges: ArrayList<Int> = arrayListOf()

) : Parcelable