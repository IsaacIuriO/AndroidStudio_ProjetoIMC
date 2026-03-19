package com.example.calculoimc.datasource

object Calculations {

    fun calculateIMC(height: String, weight: String, response: (String, Boolean) -> Unit) {

        if(height.isNotEmpty() && weight.isNotEmpty()) {

            val heightFormatted = height.toDoubleOrNull()
            val weightFormatted = weight.replace(",", ".").toDoubleOrNull()

            if (weightFormatted != null && heightFormatted != null) {

                val imc = weightFormatted / (heightFormatted / 100 * heightFormatted / 100)
                val imcFormatted = String.format("%.2f", imc)

                when {
                    imc < 18.5 -> response("IMC: $imcFormatted \nAbaixo do peso", false)
                    imc in 18.5..24.9 -> response("IMC: $imcFormatted \nPeso normal", false)
                    else -> response("IMC: $imcFormatted \nSobrepeso", false)
                }
            }
        } else {
            response("Preencha todos os campos", true)
        }
    }
}