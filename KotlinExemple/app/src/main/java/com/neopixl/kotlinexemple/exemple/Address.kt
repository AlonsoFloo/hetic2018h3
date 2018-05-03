package com.neopixl.kotlinexemple.exemple


/**
 * Created by Florian ALONSO on 4/26/18.
 * For Neopixl
 */
class Address {
    var city: String = "Paris"
    var postal: String = "75000"
    var longitude: Float = 0f
    var latitude: Float = 0f
}


data class Address2(var city: String, var postal: String, var longitude: Float, var latitude: Float)


fun maFunction() {
    val address = Address()
    address.city = "Montpellier"
    address.postal = "34090"


    val address2 = Address2("Montpellier", "34090", 0f, 0f)
    address2.city = "LOL"
}