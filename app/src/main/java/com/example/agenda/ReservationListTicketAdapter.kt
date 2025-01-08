package com.example.agenda

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.agenda.databinding.ReservationRowsBinding
import com.example.agenda.model.ReservationTicket

class ReservationListTicketAdapter(
    private val context: Context,
    private val reservationList: List<ReservationTicket>
) : RecyclerView.Adapter<ReservationListTicketAdapter.ViewHolder>() {

    class ViewHolder(
        private val reservationRowsBinding: ReservationRowsBinding
    ) :
        RecyclerView.ViewHolder(reservationRowsBinding.root) {

        fun bind(reservation: ReservationTicket) {
            reservationRowsBinding.txtReservationId.text = reservation.id
            reservationRowsBinding.txtReservationDate.text = reservation.date
            reservationRowsBinding.txtReservationStatus.text = reservation.status
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            ReservationRowsBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int  = reservationList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val reservation = reservationList[position]
        holder.bind(reservation)
    }
}