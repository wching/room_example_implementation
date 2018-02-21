package com.kohlyr.roomexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.kohlyr.roomexample.database.AppDatabase
import com.kohlyr.roomexample.database.model.Room
import com.kohlyr.roomexample.database.model.Trip
import kotlinx.android.synthetic.main.activity_main.add_history_button
import kotlinx.android.synthetic.main.activity_main.delete_last_history_button
import kotlinx.android.synthetic.main.activity_main.history_recycler
import kotlinx.android.synthetic.main.activity_main.insert_history_button
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var mHistoryAdapter: HistoryAdapter
    private lateinit var mDatabase : AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mDatabase = AppDatabase.getInstance(this)!!



        mHistoryAdapter = HistoryAdapter(mDatabase.tripDao().getAll())

        history_recycler.adapter = mHistoryAdapter
        history_recycler.layoutManager = LinearLayoutManager(this)
        add_history_button.setOnClickListener {
            val newTrip = getNewTrip()
            mDatabase.tripDao().insert(newTrip)
            addNewSearchHistory(newTrip)

        }

        delete_last_history_button.setOnClickListener {
            mDatabase.tripDao().delete(mHistoryAdapter.getItemByPosition(mHistoryAdapter.itemCount - 1))
            deleteLastTrip()
        }

        insert_history_button.setOnClickListener {
            val listOfTrips = generateTrips()
            mDatabase.tripDao().insertAll(listOfTrips)
            mHistoryAdapter.addAllTrips(listOfTrips)
            Toast.makeText(this, "Inserted!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun generateTrips(): ArrayList<Trip> {
        val dumbSearchHistory = arrayListOf<Trip>()
        val rooms = arrayListOf<Room>()
        rooms.add(Room())
        rooms.add(Room())
        rooms.add(Room())
        (1..15).mapTo(dumbSearchHistory) {
            Trip(trip = "Caracas " + it,
                    mainImageUrl = " " + it, startDate = Date(), endDate = Date())
        }


        return dumbSearchHistory
    }

    private fun getNewTrip() = Trip(trip = "Colombia " + mHistoryAdapter.itemCount,
            mainImageUrl = "", startDate = Date(), endDate = Date())

    private fun addNewSearchHistory(trip: Trip) {
        mHistoryAdapter.addItem(trip)
    }

    private fun deleteLastTrip() {
        mHistoryAdapter.deleteLastTrip()
    }
}
