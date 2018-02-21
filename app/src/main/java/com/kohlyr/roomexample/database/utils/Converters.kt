package com.kohlyr.roomexample.database.utils

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kohlyr.roomexample.database.model.RoomList
import java.util.*


class Converters {

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return when (value) {
            null -> null
            else -> Date(value)
        }
    }

    @TypeConverter
    fun toTimestamp(date: Date?): Long? {
        return when (date) {
            null -> null
            else -> date.time
        }
    }

    @TypeConverter
    fun fromString(value: String): ArrayList<Int> {
        val listType = object : TypeToken<ArrayList<Int>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: ArrayList<Int>): String = Gson().toJson(list)

    @TypeConverter
    fun fromString(value: String): RoomList {
        val listType = object : TypeToken<RoomList>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: RoomList): String = Gson().toJson(list)

}