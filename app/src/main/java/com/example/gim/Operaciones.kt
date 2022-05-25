package com.example.gim

import android.widget.Toast
import java.io.Serializable

public class Operaciones: Serializable {

    var listaClientes =arrayListOf<Cliente>()
    var contAnorexia: Int = 0
    var contDelgadez: Int = 0
    var contNormal: Int = 0
    var contObesidad1: Int = 0
    var contObesidad2: Int = 0
    var contObesidad3: Int = 0
    var contObesidad_morbida: Int = 0
    var contProcesados: Int =0

    fun registrarCliente(cliente: Cliente){

        listaClientes.add(cliente)
    }

    fun imprimirListaCliente(){
        for(cli in listaClientes){
            println(cli)
        }
    }

    fun calcularIMC(cli: Cliente): Double {

        var imc=cli.peso/(cli.talla*cli.talla);
        return imc
    }

    fun resultadoProceso(cli: Cliente): String{
        var mensajeLocal = ""
        if (cli.IMC <18 ) {
            mensajeLocal = "Anorexia"
            contAnorexia++
        } else if (cli.IMC in 18.0..20.0) {
         mensajeLocal = "Delgadez"
         contDelgadez++
        } else if (cli.IMC in 21.0..27.0) {
            mensajeLocal = "Normal"
            contNormal++
        } else if (cli.IMC in 28.0..30.0) {
            mensajeLocal = "Obesidad1"
            contObesidad1++
        } else if (cli.IMC in 31.0..35.0) {
            mensajeLocal = "Obesidad2"
            contObesidad2++
        } else if (cli.IMC in 36.0 ..40.0) {
            mensajeLocal = "Obesidad3"
            contObesidad3++
        } else if (cli.IMC > 40) {
            mensajeLocal = "Obesidad Morbida"
        contObesidad_morbida++
        }
        contProcesados += 1
        return mensajeLocal
    }

    fun cantidadProcesados(): IntArray {
        return arrayOf(
            contProcesados, contAnorexia ,contDelgadez, contNormal, contObesidad1, contObesidad1,
            contObesidad2, contObesidad3, contObesidad_morbida
        ).toIntArray()
    }

    fun devolverLista(): ArrayList<Cliente>{
       return this.listaClientes
    }
}