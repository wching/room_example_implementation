package com.kohlyr.roomexample.database.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Room(

        @PrimaryKey(autoGenerate = true)
        val mId: Int = 0,

        @ColumnInfo(name = "number_of_adults")
        val mAdults: Int = 2,

        @ColumnInfo(name = "children_ages")
        val mChildrenAges: ArrayList<Int> = arrayListOf()) : Parcelable