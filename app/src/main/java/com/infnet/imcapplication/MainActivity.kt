package com.infnet.imcapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        card_view.visibility = View.INVISIBLE
        btnCalcular.setOnClickListener {
            val peso = editTxtPeso.text.toString()
            val altura = editTxtAltura.text.toString()
            val msg = "O preenchimento de todos os campos são necessários"

            if (peso.isEmpty() and altura.isEmpty()) {
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
            } else {
                val imc = Math.round(calcularIMC(peso, altura)).toDouble()
                editTxtIMC.text = "${imc.toString()} kg/m²"
                textViewGrauObesidade.text = grauIMC(imc)
                card_view.visibility = View.VISIBLE
            }
        }
    }

    private fun calcularIMC(peso: String, altura: String): Double =
        peso.toDouble() / (altura.toDouble() * altura.toDouble())

    private fun grauIMC(indice: Double): String {
        return when (indice) {
            in 0.0..15.9 -> "Magreza grave"
            in 16.0..16.9 -> "Magreza moderada"
            in 17.0..18.4 -> "Magreza leve"
            in 18.5..24.9 -> "Saudável"
            in 25.0..29.9 -> "Sobrepeso"
            in 30.0..34.9 -> "Obesidade Grau I"
            in 35.0..39.9 -> "Obesidade Grau II (severa)"
            else -> "Obesidade Grau III (mórbida)"
        }
    }


}