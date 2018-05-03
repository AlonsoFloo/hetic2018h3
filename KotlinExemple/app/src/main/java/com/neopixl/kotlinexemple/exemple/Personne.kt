package com.neopixl.kotlinexemple.exemple

import android.util.Log
import java.util.*


/**
 * Created by Florian ALONSO on 4/26/18.
 * For Neopixl
 */

open class Personne(var nom: String, var prenom: String) : FaireDuBruit {

    var birthday: Date? = null
    val maladi: List<String> by lazy {
        emptyList<String>()
    }
    val maladi2 = emptyList<String>()

    constructor(nomCustom: String, prenomCustom: String, birthday: Date) : this(nomCustom, prenomCustom) {
        this.birthday = birthday
    }



    val age: Int
        get() {
            val trueBirthYear = birthday?.year ?: 0
            // trueBirthYear = birthday == null ? null : birthday.year
            return Date().year - trueBirthYear
        }



    fun getAgeFun(): Int {
        val trueBirthYear = birthday?.year ?: 0
        return Date().year - trueBirthYear
    }


    fun getAgeFunSolution2(): Int {
        if (birthday == null) {
            birthday = Date()
        }
        return Date().year - birthday!!.year
    }


    override fun faireDuBruit() {
        Log.d("PERSONNE", "JE FAIS DU BRUIT")
    }



}
