package com.neopixl.kotlintest


/**
 * Created by Florian ALONSO on 4/26/18.
 * For Neopixl
 */
class Address {
    var city: String = ""
    var postalCode: String = ""
    var postalCode2: String = ""
    var postalCode3: String = ""
    var postalCode4: String = ""
    var postalCode5: String = ""
    var postalCode6: String = ""
    var postalCode7: String = ""
    var postalCode8: String = ""
    var postalCode9: String = ""
}


data class AddressBis(
        var city: String,
        var postalCode: String,
        var postalCode2: String,
        var postalCode3: String
        )


fun test() {
    val address = Address()
    address.city = "Paris"
    address.postalCode = "75000"

    val addressBis = AddressBis("Paris","75000", "75000", "75000")

}
