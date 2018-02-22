package com.kohlyr.roomexample

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kohlyr.roomexample.database.model.Trip
import kotlinx.android.synthetic.main.history_item.view.destinationTextView
import kotlinx.android.synthetic.main.history_item.view.endDateTextView
import kotlinx.android.synthetic.main.history_item.view.roomsTextView
import kotlinx.android.synthetic.main.history_item.view.startDateTextView

class HistoryAdapter(private val historyList: MutableList<Trip>) :
        RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    override fun getItemCount(): Int = historyList.size

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) =
            holder.bind(historyList[position])


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder =
            HistoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.history_item,
                    parent, false))

    inner class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val destinationTextView by lazy {
            itemView.destinationTextView
        }

        private val startDateTextView by lazy {
            itemView.startDateTextView
        }

        private val endDateTextView by lazy {
            itemView.endDateTextView
        }

        private val roomsTextView by lazy {
            itemView.roomsTextView
        }

        fun bind(trip: Trip) {
            destinationTextView.text = trip.trip
//            startDateTextView.text = trip.startDate.toString()
//            endDateTextView.text = trip.endDate.toString()
//            roomsTextView.text = trip.room.size.toString()
        }
    }

    // Public Api
    fun addItem(trip: Trip) {
        historyList.add(trip)
        notifyDataSetChanged()
    }

    fun addAllTrips(trips: List<Trip>) {
        historyList.clear()
        historyList.addAll(trips)
        notifyDataSetChanged()
    }

    fun deleteLastTrip() {
        historyList.removeAt(historyList.size - 1)
    }

    fun getItemByPosition(position: Int) = historyList[position]
}