package com.example.agenda

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.agenda.databinding.ActivityMainBinding
import com.example.agenda.model.ReservationTicket

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val reservationList : MutableList<ReservationTicket> = mutableListOf()

        val adapter = ReservationListTicketAdapter(
            context = this,
            reservationList
        )

        binding.rvMain.adapter = adapter

        val reservation1 = ReservationTicket(
            id = "0000001",
            date = "Reserva para o dia 25 Dez 2024",
            status = "Registrada"

        )
        reservationList.add(reservation1)

        val reservation2 = ReservationTicket(
            id = "0000002",
            date = "Reserva para o dia 10 Jan 2025",
            status = "Registrada"

        )
        reservationList.add(reservation2)

        val reservation3 = ReservationTicket(
            id = "0000003",
            date = "Reserva para o dia 23 Jan 2025",
            status = "Registrada"

        )
        reservationList.add(reservation3)

        val reservation4 = ReservationTicket(
            id = "0000004",
            date = "Reserva para o dia 25 Fev 2025",
            status = "Registrada"

        )
        reservationList.add(reservation4)

        val reservation5 = ReservationTicket(
            id = "0000005",
            date = "Reserva para o dia 10 Junho 2025",
            status = "Registrada"

        )
        reservationList.add(reservation5)

        val fab = binding.fabMakeReservation

        fab.setOnClickListener {
            val intent = Intent(this, Reservation::class.java)
            startActivity(intent)
        }
    }
}