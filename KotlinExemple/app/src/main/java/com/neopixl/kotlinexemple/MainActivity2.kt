package com.neopixl.kotlinexemple

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.*
import java.util.regex.Pattern

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)







        val monEntier = 16
        val plus4 = monEntier + 4


        val monTableau = arrayOf(1,2,3)
        //monTableau = "String" --> Ne peut etre modifie

        Log.d("TAG", "");




        var monFloat = 6f // Est modifiable
        val monFloat2 = 6.0 // C'est un DOUBLE
        val monFloatExplicit: Float = 6f

        monFloat++ // Est modifiable car c'est un var



        val monPremierTableau = arrayOf(1,2,3,4)
        monPremierTableau.lol()

        // Supprime dans le tableau
        val monNouveauTableauPlusGrandQue3 = monPremierTableau.filter {
            it > 3
        }


        // Un Tableau mais de String
        val monNouveauTableauMaisEnString = monPremierTableau.map {
            it.toString()
        }

        // La somme de mon tableau
        var laSomme = monPremierTableau.reduce { acc, i ->
            acc + i
        }

        // Les valuer "1", "2"
        var unTableauDeString = monPremierTableau.filter {
            it < 3
        }.map {
            it.toString()
        }


        // Ceci est un lamba
        val code = {
            val i = 0
            var j = i +3
            j++
        }
        code() // Execute le code


        // compared to "arrayOf(1,2,3,4)"
        val unTableauMutable = mutableListOf(1,2,3,4);
        unTableauMutable.add(2); // Tableau final ---> 1,2,3,4,2

        val uneList = arrayListOf(1,2,3)
        uneList.add(2)
        Log.d("MonTag", "SIZE : "+ uneList.size)




        var toIncrement = 10
        val mavalue1 = toIncrement++ // Rajoute 1 --> Mavalue1 : 10
        val mavalue2 = ++toIncrement // Rajoute 1 --> Mavalue2 : 12
        // ICI MA VALEUR 12






        val multipleTypeArray: Array<Any> = arrayOf(1,2,3, "HEY", false)

        // Solution 1 pour le parcourir
        for (item in multipleTypeArray) {
            val monIntPossible: Int? = item as? Int

            Log.d("Montag", monIntPossible.toString())
            // SI c'est un INT alors la valeur est dedans
            // Sinon, c'est null
        }


        // Solution 2 pour le parcourir
        for (item in multipleTypeArray) {
            if (item is Int) {
                item.plus(1)
            } else if (item is String && item.isEmpty()) {
                item.replace("Salut", "")
            } else if (item is Boolean) {
                item.not()
            }
        }


        // Solution 3 pour le parcourir
        for (item in multipleTypeArray) {
            when(item) {
                is Int -> item.plus(1)
                is String -> item.replace("Salut", "")
                is Boolean -> item.not()
            }
        }




        val sum: (Int, Int) -> Int = { x, y ->
            x + y
        }

        val resultat = sum(1,5) // ---> 6


        val multiplyByThree: (Int) -> Int = {x ->
            x * 3
        }
        val multiplyByThree2 = {x: Int ->
            x * 3
        }
        val multiplyByThree3: (Int) -> Int = {
            it * 3
        }
        val maValuer = 3
        multiplyByThree(3) // Avec un lamdas


        // Solution 1
        val email = "florian@neopixl_com"
        val isValid = isEmailValid(email)


        // Solution 2
        val email2 = "florian@neopixl_com"
        val isValid2 = email2.isEmail()


        10.power(5)
        10 power 5

    }

    fun isEmailValid(email: String) : Boolean {
        val regex = "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        return Pattern.compile(regex).matcher(email).matches()
    }

    fun Array<Int>.lol() {
        Log.d("MonTag", "Hey LOL")
    }



    fun testDeChangementDeReference(): Boolean {

        var personneMutable = Personne("ALONSO", "Florian")
        personneMutable.nom = "ALONSO"
        personneMutable.prenom = "Florian"
        personneMutable.age

        personneMutable = Personne("MOTE", "Yvan", Date()) // Je change de personne
        personneMutable.nom = "MOTE"
        personneMutable.prenom = "Yvan"
        personneMutable.age

        val personne = Personne2()
        personne.nom = "ALONSO"
        personne.prenom = "Florian"


        personne.getAgeFun()
        personne.age

        personneMutable.maladi



        //personne = Personne("MOTE", "Yvan")// Imutable donc changement impossible

        personne.nom = "GITMAN"

        return true
    }


    fun hideButton(callback: (succes: Boolean) -> Void) {
        // Je cache le bouton
        var i = 0
        val j = i++
        // Je cache le button



        callback(true)

    }
}

fun String.isEmail() : Boolean {
    val regex = "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
    return Pattern.compile(regex).matcher(this).matches()
}

infix fun Int.power(power: Int): Int {
    if(power==0) return 1

    var result = this

    for(i in 1..power-1) {
        result *= this
    }

    return result
}