package com.kohlyr.roomexample.database.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import android.os.Parcelable
import com.kohlyr.roomexample.database.utils.Converters
import kotlinx.android.parcel.Parcelize
import java.util.Calendar
import java.util.Date

@Entity(tableName = "trips")
@Parcelize
data class Trip(

		@PrimaryKey(autoGenerate = true)
		var id: Long = 0,

		@ColumnInfo(name = "trip")
		var trip: String = "",

		@ColumnInfo(name = "main_image_url")
		var mainImageUrl: String = "",

		@ColumnInfo(name = "start_date")
		@TypeConverters(Converters::class)
		var startDate: Date = Calendar.getInstance().time,

		@ColumnInfo(name = "end_date")
		@TypeConverters(Converters::class)
		var endDate: Date = Calendar.getInstance().time

) : Parcelable
