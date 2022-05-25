package com.example.gim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button

class Ayuda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayuda)

        supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val btnAtras = findViewById<Button>(R.id.btnAtras)
        btnAtras.setOnClickListener { onAtrasClick() }
    }

    fun onAtrasClick() {
        val iniciar = Intent(this,MainActivity::class.java)
        startActivity(iniciar)//inicio la actividad
    }
}