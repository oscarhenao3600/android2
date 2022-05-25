package com.example.gim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button


class MainActivity : AppCompatActivity() {

    //Se declara la clase operaciones para la logica del sistema
    var operaciones: Operaciones?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        //Se instancia la clase operaciones
        operaciones = Operaciones()

        iniciarComponentes()

    }
    private fun iniciarComponentes() {
        val botonRegistro: Button =findViewById(R.id.btnRegistro)
         val botonAyuda: Button =findViewById(R.id.btnAyuda)

        botonRegistro.setOnClickListener { onClick(1) }
        botonAyuda.setOnClickListener { onClick(2) }
    }

    private fun onClick(boton: Int) {
        when(boton){
            1->{
                var miIntent:Intent= Intent(this,Registro::class.java)
                var miBundle:Bundle= Bundle()
                miBundle.putSerializable("operaciones", operaciones)
                miIntent.putExtras(miBundle)
                startActivity(miIntent)
                //response.launch(miIntent)
                startActivity(Intent(this,Registro::class.java))
            }
            2->startActivity(Intent(this,Ayuda::class.java))
        }
    }



}
