package com.neopixl.kotlintest

import java.util.*


/**
 * Created by Florian ALONSO on 4/26/18.
 * For Neopixl
 */
class PersonneConstruct(val nom: String, var prenom: String) {

    constructor(newNom: String, newPrenom: String, newBirthday: Date) : this(newNom, newPrenom) {
        this.birthday = newBirthday
    }


    var birthday: Date? = null


    val age: Int
        get() {
            val trueBirthday = birthday?.year ?: Date().year
            // JAVASCRIPT EQUIVALENT --> val i = birthday != null ? birthday.year : 0

            return Date().year - trueBirthday

            // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            //return Date().year - birthday!!.year // Ne pas utiliser, c'esdt DANGER !!!!!!!!
        }

}