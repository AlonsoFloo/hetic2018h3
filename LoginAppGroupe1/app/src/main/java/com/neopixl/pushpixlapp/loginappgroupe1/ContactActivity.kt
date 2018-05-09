package com.neopixl.pushpixlapp.loginappgroupe1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.android.volley.NetworkResponse
import com.android.volley.Request
import com.android.volley.VolleyError
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import com.neopixl.pushpixlapp.loginappgroupe1.fastadapter.ContactItem
import com.neopixl.pushpixlapp.loginappgroupe1.model.Contact
import com.neopixl.pushpixlapp.loginappgroupe1.model.ContactResultWrapper
import com.neopixl.spitfire.listener.RequestListener
import com.neopixl.spitfire.request.BaseRequest
import kotlinx.android.synthetic.main.activity_contact.*

class ContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)


        val newParameters = mutableMapOf<String, String>()
        newParameters["results"] = "5000"
        newParameters["seed"] = "lol /+="

        val request = BaseRequest.Builder<ContactResultWrapper>(
                Request.Method.GET,
                "https://randomuser.me/api",
                ContactResultWrapper::class.java
        )
                .listener(object : RequestListener<ContactResultWrapper> {
                    override fun onSuccess(request: Request<*>?, response: NetworkResponse?, result: ContactResultWrapper?) {
                        Toast.makeText(this@ContactActivity, "A SUCCESS", Toast.LENGTH_SHORT).show()

                        if (result != null) {
                            // SUCCESS
                            val listOfContacts = result.results
                            displayContacts(listOfContacts)
                        }
                    }

                    override fun onFailure(request: Request<*>?, response: NetworkResponse?, error: VolleyError?) {
                        Toast.makeText(this@ContactActivity, "A NETWROK ERROR", Toast.LENGTH_SHORT).show()
                    }
                })
                .parameters(newParameters)
                .build()

        LoginApplication.shared.requestQueue.add(request)

    }

    fun displayContacts(listOfContacts: Array<Contact>) {
        val monAdapter = FastItemAdapter<ContactItem>()
        for (contact: Contact in listOfContacts) {
            val item = ContactItem(contact)
            monAdapter.add(item)
            //monAdapter.remove()
            //monAdapter.set()
        }
        recyclerView.adapter = monAdapter

        val monLinearLayoutManager = LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,
                false)
        val gridLayoutManager = GridLayoutManager(this,
                3,
                GridLayoutManager.VERTICAL,
                false) // THIS IS AN EXAMPLE
        recyclerView.layoutManager = monLinearLayoutManager



        monAdapter.withOnClickListener({ view, adapter, item, position ->
            /*if (item.contact.nom == "ALONSO") {
                Toast.makeText(this,
                        "CLICKED ON FLORIAN",
                        Toast.LENGTH_SHORT)
                        .show()
            }

            monAdapter.remove(position)
            */

            false // Ou true
        })
    }
}
