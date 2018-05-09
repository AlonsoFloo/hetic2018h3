package com.neopixl.pushpixlapp.loginappgroupe2

import android.app.Application
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

/**
 * Created by Yvan Moté on 09/05/2018.
 */

// Classe centrale (instanciée au démarrage de l'app)
class LoginApp: Application() {

    companion object {
        lateinit var instance: LoginApp
    }

    lateinit var requestQueue: RequestQueue

    // Méthode appelée au démarrage de l'app (une seule fois)
    override fun onCreate() {
        super.onCreate()

        LoginApp.instance = this
        requestQueue = Volley.newRequestQueue(this)
    }

}