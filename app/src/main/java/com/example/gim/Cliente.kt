package com.example.gim

import java.io.Serializable

class Cliente: Serializable {
    var tipo: String=""
    var nombre: String=""
    var edad: Int=0
    var peso: Double=0.0
    var talla: Double=0.0
    var IMC:Double=0.0

    override fun toString(): String {
        return "Cliente(nombre='$nombre',edad='$edad',peso='$peso',talla='$talla',IMC='$IMC','tipo='$tipo)"
    }
}