package com.ulisesdiaz.listview.models

import android.graphics.Color

class Fruta(nombre:String, imagen: Int, colorCelda:Int) {

    var nombre:String? = ""
    var imagen:Int = 0
    var colorCelda: Int = Color.WHITE

    init{
        this.nombre = nombre
        this.imagen = imagen
        this.colorCelda = colorCelda
    }
}