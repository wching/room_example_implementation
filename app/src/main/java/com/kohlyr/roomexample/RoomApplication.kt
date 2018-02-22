package com.kohlyr.roomexample

import android.app.Application
import com.facebook.stetho.Stetho

/**
 * Created by wching on 22.02.18.
 */
class RoomApplication : Application() {
	override fun onCreate() {
		super.onCreate()
		Stetho.initializeWithDefaults(this)
	}
}