package com.example.gim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.Intent
import android.view.WindowManager
import android.widget.Button

class Estadisticas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estadisticas)
        supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val campoTextoCliente: TextView = findViewById(R.id.mensaje1)
        val campoTextoAnorexia: TextView = findViewById(R.id.textAnorexia)
        val campoTextoDelgadez: TextView = findViewById(R.id.textDeldadez)
        val campoTextoNormal: TextView = findViewById(R.id.textNormal)
        val campoTextoObesidad1: TextView = findViewById(R.id.textObesidad1)
        val campoTextoObesidad2: TextView = findViewById(R.id.textObesidad2)
        val campoTextoObesidad3: TextView = findViewById(R.id.textObesidad3)
        val campoTextoObesidadMorbida: TextView = findViewById(R.id.textMorbida)
        val campoTextoProcesados: TextView = findViewById(R.id.textPro)
        val bundleData: Bundle? = this.intent.extras


        if (bundleData != null){
            campoTextoCliente.text = bundleData.getString("listaclientes")
            val procesados = bundleData.getIntArray("procesados")

            campoTextoAnorexia.text = procesados?.get(0).toString()
            campoTextoDelgadez.text = procesados?.get(2).toString()
            campoTextoNormal.text = procesados?.get(3).toString()
            campoTextoObesidad1.text = procesados?.get(1).toString()
            campoTextoObesidad2.text = procesados?.get(4).toString()
            campoTextoObesidad3.text = procesados?.get(6).toString()
            campoTextoObesidadMorbida.text = procesados?.get(5).toString()
            campoTextoProcesados.text = procesados?.get(7).toString()
        }

        val btnAtras = findViewById<Button>(R.id.btnAtras1)
        btnAtras.setOnClickListener { onAtrasClick() }


    }
    fun onAtrasClick() {
        val iniciar = Intent(this,MainActivity::class.java)
        startActivity(iniciar)//inicio la actividad
    }
}