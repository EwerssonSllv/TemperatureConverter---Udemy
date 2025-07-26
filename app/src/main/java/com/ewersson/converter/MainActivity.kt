package com.ewersson.converter


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var celsiusRadio: RadioButton
    private lateinit var fahrenheitRadio: RadioButton
    private lateinit var converterButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.valorTemp)!!
        celsiusRadio = findViewById(R.id.celsiusRadio)
        fahrenheitRadio = findViewById(R.id.fahrenheitRadio)

        converterButton = findViewById(R.id.converterButton)
        converterButton.setOnClickListener { converter(it) }
    }

    private fun converter(view: View) {
        val tempS: String = editText.text.toString()
        if (tempS.isNotEmpty()) {
            try {
                var temp: Double = editText.text.toString().toDouble()

                if (celsiusRadio.isChecked) {
                    temp = (temp - 32) * 5 / 9
                } else if (fahrenheitRadio.isChecked) {
                    temp = temp * 9 / 5 + 32
                }

                editText.setText(temp.toString())
            } catch (e: Exception) {
                Toast.makeText(
                    view.context,
                    "Erro ao converter medida! Error: ${e.message}",
                    Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(
                view.context,
                "Digite a temperatura!",
                Toast.LENGTH_SHORT).show()
        }
    }


}