package com.neopixl.kotlinexemple

import java.util.*


/**
 * Created by Florian ALONSO on 4/26/18.
 * For Neopixl
 */

class Personne2 {

    var nom: String = ""
    var prenom: String
        get() = prenom
        set(value) {
            prenom = value + "YOLO"
        }




    var birthday = Date()

    val age: Int
        get() = Date().year - birthday.year



    fun getAgeFun(): Int {
        this.prenom = "Florian"
        return Date().year - birthday.year
    }




}
