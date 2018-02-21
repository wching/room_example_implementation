package com.kohlyr.roomexample.database.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Entity
@Parcelize
data class Trip(

        @PrimaryKey(autoGenerate = true)
        val id: Int = 0,

        @ColumnInfo(name = "trip")
        val trip: String = "",

        @ColumnInfo(name = "main_image_url")
        val mainImageUrl: String = "",

        @ColumnInfo(name = "start_date")
        val startDate: Date = Date(),

        @ColumnInfo(name = "end_date")
        val endDate: Date = Date(),

        @ColumnInfo(name = "rooms")
        val room: RoomList = RoomList(arrayListOf())) : Parcelable