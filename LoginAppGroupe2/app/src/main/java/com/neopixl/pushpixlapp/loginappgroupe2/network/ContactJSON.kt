package com.neopixl.pushpixlapp.loginappgroupe2.network

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

/**
 * Created by Yvan Moté on 09/05/2018.
 */


@JsonIgnoreProperties(ignoreUnknown = true)  // Trick: pas viable en production
class ContactJSON {
    var gender = ""
    lateinit var name: ContactJSONName
}

class ContactJSONName {
    var title = ""
    var first = ""
    var last = ""

}