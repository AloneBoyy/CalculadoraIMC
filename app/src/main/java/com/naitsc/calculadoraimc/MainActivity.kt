package com.naitsc.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.naitsc.calculadoraimc.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCalcular.setOnClickListener {

            val editpeso = binding.editPeso.text.toString()
            val editaltura = binding.editAltura.text.toString()
            val mensagem = binding.msg

            if (editpeso.isEmpty()) {
                mensagem.setText("Informe o seu Peso ")

            } else if (editaltura.isEmpty()) {
                mensagem.setText("Informe sua Altura")

            } else {
                CalculoDeIMC()
            }

        }
    }

    private fun CalculoDeIMC() {
        val pesoID = binding.editPeso
        val alturaID = binding.editAltura

        val peso = Integer.parseInt(binding.editPeso.text.toString())
        val altura = java.lang.Float.parseFloat(alturaID.text.toString())
        val resultado = binding.msg
        val imc = peso / (altura * altura)

        val mensagem = when {
            imc <= 18.5 -> "Peso Baixo"
            imc <= 24.9 -> "Peso Normal"
            imc <= 29.9 -> "Sobre Peso"
            imc <= 34.9 -> "Obesidade (Grau I)"
            imc <= 39.9 -> "Obesidade (Grau II)"
            else -> "ObesidadeMórbida (Grau III)"

        }
        imc.toString()
        resultado.setText("IMC: $imc \n\n $mensagem")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflate = menuInflater
        inflate.inflate(R.menu.menu_principal, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.reset -> {
                val limparEditPeso = binding.editPeso
                val limparEditAltua = binding.editAltura
                val limparMensagem = binding.msg

                limparEditPeso.setText("")
                limparEditAltua.setText("")
                limparMensagem.setText("")
            }
        }


        return super.onOptionsItemSelected(item)
    }

    private fun olar(){

    }
}