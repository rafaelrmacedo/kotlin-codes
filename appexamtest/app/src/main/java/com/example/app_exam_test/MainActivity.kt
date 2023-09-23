package com.example.app_exam_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val formatoNumero = DecimalFormat("#.00")
        val edtOperando1 = findViewById<EditText>(R.id.edtOperando1)
        val edtOperando2 = findViewById<EditText>(R.id.edtOperando2)
        val textResultado = findViewById<TextView>(R.id.textResultado)
        val btnLimpar = findViewById<Button>(R.id.btnLimpar)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        btnLimpar.setOnClickListener(){
            edtOperando1.text.clear()
            edtOperando2.text.clear()
            textResultado.setText("Resultado aparece aqui")
            edtOperando1.requestFocus()
        }

        btnCalcular.setOnClickListener(){
            if (edtOperando1.text.isEmpty() and edtOperando2.text.isEmpty()){
                val msgToast = Toast.makeText(this, "Você deve digitar em todos os campos", LENGTH_SHORT).show()
            } else if (edtOperando2.text.isEmpty()){
                val msgToast = Toast.makeText(this, "Você deve digitar no segundo campo também", LENGTH_SHORT).show()
            } else if (edtOperando1.text.isEmpty()){
                val msgToast = Toast.makeText(this, "Você deve digitar no primeiro campo também", LENGTH_SHORT).show()
            } else {
                val resultado = edtOperando1.text.toString().toFloat() - edtOperando2.text.toString().toFloat()
                textResultado.setText("Resultado é: " + formatoNumero.format(resultado).toString())
            }
        }
    }
}