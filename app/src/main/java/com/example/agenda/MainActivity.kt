package com.example.agenda

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.agenda.databinding.ActivityMainBinding
import com.example.agenda.common.model.ReservationTicket

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.extras?.getString("key_name")?.split(" ")?.firstOrNull() ?: throw IllegalArgumentException("name not found")

        val reservationList : MutableList<ReservationTicket> = mutableListOf()

        val adapter = ReservationListTicketAdapter(
            context = this,
            reservationList
        )

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

        binding.rvMain.adapter = adapter

        binding.toolbarMain.title = getString(R.string.welcome,name)

        if (reservationList.isEmpty()){
            binding.txtInfoReservation.text = getString(R.string.you_havent_made_your_reservation)

        } else {
            binding.txtInfoReservation.text = getString(R.string.here_is_your_reservation)
        }

        val fab = binding.fabMakeReservation

        fab.setOnClickListener {
            val intent = Intent(this, ReservationActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_top)
        }
    }

    companion object {
        const val KEY_NAME = "key_name"
    }
}