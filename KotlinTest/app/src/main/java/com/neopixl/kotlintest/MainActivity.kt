package com.neopixl.kotlintest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var monEntier: Int = 3
        var monEntier2 = 3

        monEntier = 2 // Ca marche
        //monEntier = "" // Ca marche PAS


        var monFloat = 6.5f
        val monDouble = 6.5

        //monFloat = monFloat * 2.3 // Ne fonctionne pas car 2.3 est un double


        monFloat = monFloat + 3.0f
        //monDouble = monDouble + 3.0 // Ne fonctionne pas car c'est un val



        val monTableau: Array<Int> = arrayOf(1,2,3,4,5,6,7,8,9)
        val maList: MutableList<Int> = arrayListOf(1,2,3,4,5,6,7,8,9)
        val monTableauString: Array<String> = arrayOf("HEY", "SALUT")
        val monTableauMixte: Array<Any> = arrayOf("HEY", 10) // Eviter au possible
        monTableau[0] = 10 // Aucun tableau cree donc OK
        //monTableau = arrayOf(10,2,3,4,5,7,8,9) // Creation d'un nouveau tableau donc impossible

        val leChiffre2 = monTableau.filter {
            // Condition true ou false
            it == 2
        }.first()

        val leChiffre2Bis = monTableau.filter {item ->
            // Condition true ou false
            item == 2
        }.first()


        maList.add(10);
        maList.add(11);
        maList.removeAt(0);
        // 2,3,4,5,6,7,8,9,10,11




        var i = 0;
        var test1 = i++; // Increment de 1 --> test1 = 0
        var test2 = ++i; // Increment de 1 --> test2 = 2
        // i vaut 2 maintenant


        when(i) {
            1-> Log.d("Montag", "La valeur est 1")
            2,3,4-> Log.d("Montag", "La valeur est 2 ou 3 ou 4")
            else -> {
                Log.d("JE SAIS PAS", "JE SAIS PAS")
            }
        }


        maFonctionAvecParams("MonString", emptyArray())


        test2.moins(4)
        var six = 10 moins 4



        val personne = Personne()
        personne.nom.length // Taille fait 0
        personne.nom = "ALONSO"
        personne.prenom = "Florian" // LE RESULTAT --> "FlorianYOLO"
        personne.nom.length // Taille fait 6
        personne.birthday = Date(2000, 1, 1)

        personne.getAgeFunction() // --> 18
        personne.age // --> 18
        //personne.age = 10 // IMPOSSIBLE
        personne.pokemon.size

        val personne2 = PersonneConstruct("MOTE", "Yvan")
        val personne2Bis = PersonneConstruct("MOTE", "Yvan", Date())
        personne2.prenom = "Yvan"

        personne2.nom
        personne2Bis.age
        personne.age


        personne.prenom = "JHJKJK"
        personne.prenom = "JHJKasdasdJK"
        personne.prenom = "JHJKhtkhlkhjJK"
        //personne.prenom = null






        val monTableauMixteDeux: Array<Any> = arrayOf("HEY", 10, true)
        // SOLUTION 1
        for (item in monTableauMixteDeux) {
            val monEntierOptionnel = item as? Int
            monEntierOptionnel?.plus(10)

            val monEntier = (item as? Int) ?: 0
            monEntier.plus(10)
        }

        // SOLUTION 2
        for (item in monTableauMixteDeux) {
            if (item is Int) {
                item.plus(10)
            } else if (item is String && item.endsWith("Y")) {
                item.length
            } else if (item is Boolean) {
                item.not()
            }
        }

        // SOLUTION 3
        for (item in monTableauMixteDeux) {
            when(item) {
                is Int -> item.plus(10)
                is String -> item.length
                is Boolean -> item.not()
            }
        }




        ajax("http://google.fr", {succes: Boolean ->
            Log.d("HEY", "LE RETOUR"+ succes)
            var i = 9
            System.out.print(succes)
            i++
        })



        val monPremierString = "Salut"
        val monDeuxiemeString = "Hey"
        val monTroisiemeString = "Salut"
        val monQuatriemeString = monPremierString
        val LOL = true


        monPremierString == monDeuxiemeString // false
        monPremierString == monTroisiemeString // true
        monPremierString === monTroisiemeString // false
        monPremierString === monQuatriemeString // true
        monPremierString == monQuatriemeString // true


        val email = "florian@neopixl_com"
        email.isEmail() // false
        "Salut".isEmail() // false
        "florian@neopixl.com".isEmail() // True

    }


    fun maFonctionSansRetour() {
        var i = 0
        i++
        val j = i - 1
    }

    fun maFonctionAvecRetour() : Boolean {
        var i = 0
        i++
        val j = i - 1
        return false
    }

    fun maFonctionAvecParams(param1: String, param2: Array<Boolean>) {


    }

    fun ajax(url:String, callback: (success: Boolean) -> Int) {
        // FAIRE LA REQUETTE RESEAU


        // ENVOYER l'INFO AU CALLBACK
        callback(false)
    }
}


infix fun Int.moins(valeur: Int) : Int {
    return this - valeur
}



fun String.isEmail() : Boolean {
    val regex = "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
    return Pattern.compile(regex).matcher(this).matches()
}