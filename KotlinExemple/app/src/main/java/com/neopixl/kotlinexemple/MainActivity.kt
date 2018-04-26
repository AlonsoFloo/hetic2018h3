package com.neopixl.kotlinexemple

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.*

class MainActivity : AppCompatActivity() {

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
        uneList.removeAt(0)




        var toIncrement = 10
        val mavalue1 = toIncrement++ // Rajoute 1 --> Mavalue1 : 10
        val mavalue2 = ++toIncrement // Rajoute 1 --> Mavalue2 : 12
        // ICI MA VALEUR 12



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



        //personne = Personne("MOTE", "Yvan")// Imutable donc changement impossible

        personne.nom = "GITMAN"

        return true
    }
}
