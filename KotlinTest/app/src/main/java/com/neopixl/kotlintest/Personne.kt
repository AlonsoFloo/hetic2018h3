package com.neopixl.kotlintest

import java.util.*


/**
 * Created by Florian ALONSO on 4/26/18.
 * For Neopixl
 */
open class Personne {

    val pokemon: Array<String> by lazy {
        arrayOf<String>("Pikachu", "Salameche")
    }

    var nom: String = ""
    var prenom: String
        get() = this.prenom
        set(value) {
            this.prenom = value +"YOLO"
        }

    var birthday = Date()
    val age: Int
        get() = Date().year - birthday.year



    fun getAgeFunction() : Int {
        return Date().year - birthday.year
    }

}