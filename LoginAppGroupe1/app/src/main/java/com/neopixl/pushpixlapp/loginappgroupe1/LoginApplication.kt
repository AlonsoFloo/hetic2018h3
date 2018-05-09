package com.neopixl.pushpixlapp.loginappgroupe1

import android.app.Application
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley


/**
 * Created by Florian ALONSO on 5/9/18.
 * For Neopixl
 */


class LoginApplication() : Application() {

    lateinit var requestQueue: RequestQueue

    companion object {
        lateinit var shared: LoginApplication
    }

    override fun onCreate() {
        super.onCreate()

        shared = this

        requestQueue = Volley.newRequestQueue(applicationContext)
        requestQueue.start()
    }

}