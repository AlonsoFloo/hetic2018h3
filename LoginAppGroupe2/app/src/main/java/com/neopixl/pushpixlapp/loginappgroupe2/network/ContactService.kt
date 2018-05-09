package com.neopixl.pushpixlapp.loginappgroupe2.network

import com.android.volley.NetworkResponse
import com.android.volley.Request
import com.android.volley.VolleyError
import com.neopixl.pushpixlapp.loginappgroupe2.LoginApp
import com.neopixl.spitfire.listener.RequestListener
import com.neopixl.spitfire.request.BaseRequest

/**
 * Created by Yvan Moté on 09/05/2018.
 */
class ContactService {

    interface ContactServiceListener {
        fun onReceiveResult(contacts: List<ContactJSON>)
        fun onFailed()
    }

    companion object {
        fun getContacts(listener: ContactServiceListener) {

            val url = UrlBuilder.getContactUrl()

            var request = BaseRequest
                    // appel une URL en GET et parse le JSON pour faire un objet de type ContactResult
                    .Builder<ContactResult>(Request.Method.GET, url, ContactResult::class.java)
                    .listener(object: RequestListener<ContactResult>{
                        override fun onSuccess(request: Request<*>?, response: NetworkResponse?, result: ContactResult?) {
                            // La requête s'est bien déroulée

                            if(result is ContactResult) {
                                listener.onReceiveResult(result.results)
                            }

                        }

                        override fun onFailure(request: Request<*>?, response: NetworkResponse?, error: VolleyError?) {
                            // La requête a échouée (erreur réseau ou parsing JSON)
                            listener.onFailed()
                        }

                    })

            // Envoi de la requête (appel WS) dans la requestQueue principale
            LoginApp.instance
                    .requestQueue.add(request.build())

        }
    }

}