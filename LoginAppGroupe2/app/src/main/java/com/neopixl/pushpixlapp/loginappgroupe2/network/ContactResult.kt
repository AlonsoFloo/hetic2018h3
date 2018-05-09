package com.neopixl.pushpixlapp.loginappgroupe2.network

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

/**
 * Created by Yvan Moté on 09/05/2018.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
class ContactResult {
    var results = arrayListOf<ContactJSON>()
}