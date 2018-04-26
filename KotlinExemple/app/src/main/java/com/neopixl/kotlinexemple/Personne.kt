package com.neopixl.kotlinexemple

import java.util.*


/**
 * Created by Florian ALONSO on 4/26/18.
 * For Neopixl
 */

class Personne(var nom: String, var prenom: String) {

    var birthday: Date? = null

    constructor(nomCustom: String, prenomCustom: String, birthday: Date) : this(nomCustom, prenomCustom) {
        this.birthday = birthday
    }



    val age: Int
        get() {
            val trueBirthYear = birthday?.year ?: Date().year
            // trueBirthYear = birthday == null ? null : birthday.year
            return Date().year - trueBirthYear
        }



    fun getAgeFun(): Int {
        this.prenom = "Florian"
        return Date().year - birthday.year
    }




}
