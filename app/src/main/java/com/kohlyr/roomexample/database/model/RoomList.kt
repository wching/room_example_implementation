package com.kohlyr.roomexample.database.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by kohlyr on 2/18/18.
 */
@Parcelize
data class RoomList(val arrayList: ArrayList<Room>) : Parcelable