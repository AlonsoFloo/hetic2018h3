package com.neopixl.pushpixlapp.loginappgroupe2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.neopixl.pushpixlapp.loginappgroupe2.model.Contact

class ContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        val contactsList = arrayListOf<Contact>()

        contactsList.add(Contact("Justin","Case"))
        contactsList.add(Contact("Herbert","Stein"))
        contactsList.add(Contact("John","Connor"))
        contactsList.add(Contact("Lucie","Fer"))
        contactsList.add(Contact("Jared","Tout"))
        contactsList.add(Contact("Bernard","Tapis"))
        contactsList.add(Contact("Mike","Penz"))
        contactsList.add(Contact("Jason","Sparc"))
        contactsList.add(Contact("Allan","Wang"))
        contactsList.add(Contact("Mattias","Bergander"))
        contactsList.add(Contact("Alex","Gotev"))
        contactsList.add(Contact("Bernardo","Ferrari"))
        contactsList.add(Contact("Yuri","Heupa"))




    }
}
