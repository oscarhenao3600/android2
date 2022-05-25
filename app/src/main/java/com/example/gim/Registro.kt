package com.example.gim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.view.WindowManager


class Registro : AppCompatActivity() {

    var campoNombre:EditText?=null
    var campoEdad:EditText?=null
    var campoTalla:EditText?=null
    var campoPeso:EditText?=null
    var operaciones:Operaciones? = null
    var tipo=""
    var mensaje=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        iniciarComponentes()
    }

    private fun iniciarComponentes() {
        operaciones = Operaciones()

        campoNombre=findViewById(R.id.editTextNombre)
        campoEdad=findViewById(R.id.editTextEdad)
        campoPeso=findViewById(R.id.editTextPeso)
        campoTalla=findViewById(R.id.editTextTalla)

        var btnRegistrar: Button=findViewById(R.id.btnRegistro1)
        btnRegistrar.setOnClickListener { registrarCliente()}

        var btnVerEstadisticas: Button = findViewById(R.id.btnEstadistica1)
        btnVerEstadisticas.setOnClickListener { cargarEstadisticas() }

    }

    private fun cargarEstadisticas() {
        var listaclientes: ArrayList<Cliente> = operaciones!!.devolverLista()
        var mensaje_estadisticas: String = formatearLista(listaclientes)
        var procesados: IntArray = operaciones!!.cantidadProcesados()

        val intent = Intent(this, Estadisticas::class.java)
        val miBundle: Bundle = Bundle()
        miBundle.putString("listaclientes", mensaje_estadisticas)
        miBundle.putIntArray("procesados", procesados)
        intent.putExtras(miBundle)
        startActivity(intent)

    }

    private fun formatearLista(listaClientes: ArrayList<Cliente>): String {
        var mensaje = ""

        for (cliente in listaClientes){
            mensaje += "Nombre: ${cliente.nombre}\n"
            mensaje += "Edad: ${cliente.edad}\n"
            mensaje += "Peso: ${cliente.peso}\n"
            mensaje += "Talla: ${cliente.talla}\n"
            mensaje += "IMC: ${cliente.IMC}\n\n\n"
        }
        return mensaje
    }

    private fun registrarCliente() {

        if (campoNombre?.text?.length == 0) {
            Toast.makeText(this,"El campo Nombre esta vacio", Toast.LENGTH_LONG).show()
            return
        }
        if (campoEdad?.text?.length == 0) {
            Toast.makeText(this,"La edad no puede ser menor de 0", Toast.LENGTH_LONG).show()
            return
        }
        if (campoPeso?.text?.length == 0) {
            Toast.makeText(this,"El peso no puede ser negativo", Toast.LENGTH_LONG).show()
            return
        }
        if (campoTalla?.text?.length == 0) {
            Toast.makeText(this,"La altura no puede ser menor a 0", Toast.LENGTH_LONG).show()
            return
        }

        var mensaje = ""
        var continuar = true

        var edad = campoEdad?.text.toString().toInt()
        var peso = campoPeso?.text.toString().toDouble()
        var talla = campoTalla?.text.toString().toDouble()
        if(edad < 0 || edad > 100){
            mensaje += "La edad esta fuera de rango\n"
            continuar = false
        }
        if(peso< 0 || peso > 1000){
            mensaje += "El peso esta fuera de rango\n"
            continuar = false
        }
        if(talla < 0 || talla > 3){
            mensaje += "La talla esta fuera de rango\n"
            continuar = false
        }
        if (continuar){
            var cli: Cliente = Cliente()
            cli.nombre = campoNombre?.text.toString()
            cli.edad = campoEdad?.text.toString().toInt()
            cli.peso = campoPeso?.text.toString().toDouble()
            cli.talla = campoTalla?.text.toString().toDouble()

            cli.IMC = operaciones!!.calcularIMC(cli)
            cli.tipo = operaciones!!.resultadoProceso(cli)
            operaciones?.registrarCliente(cli)
            operaciones?.imprimirListaCliente()
        }
        else
        {
            Toast.makeText(this,"Los siguientes campos están incorrectos\n $mensaje ", Toast.LENGTH_LONG).show()
        }

    }

}



