package com.neopixl.pushpixlapp.loginappgroupe1.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties


/**
 * Created by Florian ALONSO on 5/9/18.
 * For Neopixl
 */

@JsonIgnoreProperties(ignoreUnknown = true)
class Contact {
    var email: String = ""
    var gender: String = ""
    var name: ContactName = ContactName()
    var picture: ContactPhoto = ContactPhoto()
}