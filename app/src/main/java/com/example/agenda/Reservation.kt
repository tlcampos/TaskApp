package com.example.agenda

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.agenda.api.Api
import com.example.agenda.databinding.ActivityReservationBinding
import com.example.agenda.model.Endereco
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Reservation : AppCompatActivity() {
    private lateinit var binding: ActivityReservationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReservationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Configurar o Retrofit
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://viacep.com.br/ws/")
            .build()
            .create(Api::class.java)

        binding.txtEditPostalCode.setOnClickListener {
            val cep = binding.txtEditPostalCode.text.toString()

            if (cep.isEmpty()) {
                binding.txtEditPostalCode.error = "Digite um CEP"
                return@setOnClickListener
            } else {
                retrofit.setEndereco(cep).enqueue(object : retrofit2.Callback<Endereco> {
                    override fun onResponse(call: Call<Endereco>, response: Response<Endereco>) {
                        if (response.code() == 200) {
                            val logradouro = response.body()?.logradouro
                            val bairro = response.body()?.bairro
                            val localidade = response.body()?.localidade
                            val uf = response.body()?.uf
                            setAdressForm(logradouro.toString(), bairro.toString(), localidade.toString(), uf.toString())
                        }else {
                            Toast.makeText(applicationContext, "Cep Invalido!", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<Endereco>, t: Throwable) {
                        Toast.makeText(applicationContext, "Erro inesperado!", Toast.LENGTH_SHORT).show()

                    }
                })

            }
        }
    }

    private fun setAdressForm(logradouro: String, bairro: String, localidade: String, uf: String){
        binding.txtEditStreet.setText(logradouro)
        binding.txtEditNeighborhood.setText(bairro)
        binding.txtEditCity.setText(localidade)
        binding.txtEditState.setText(uf)
    }
}