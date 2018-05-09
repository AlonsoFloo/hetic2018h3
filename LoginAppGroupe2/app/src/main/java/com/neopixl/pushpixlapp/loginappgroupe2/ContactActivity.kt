package com.neopixl.pushpixlapp.loginappgroupe2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.mikepenz.fastadapter.IAdapter
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import com.mikepenz.fastadapter.listeners.OnClickListener
import com.neopixl.pushpixlapp.loginappgroupe2.item.ContactItem
import com.neopixl.pushpixlapp.loginappgroupe2.model.Contact
import com.neopixl.pushpixlapp.loginappgroupe2.network.ContactJSON
import com.neopixl.pushpixlapp.loginappgroupe2.network.ContactService
import kotlinx.android.synthetic.main.activity_contact.*

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

        // configuration de l'affichage à la verticale

        // LinearLayoutManager || GridLayoutManager
        contactRecyclerView.layoutManager = LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        val itemAdapter = FastItemAdapter<ContactItem>()

        // liaison de l'adaptateur à la liste (RecyclerView)
        contactRecyclerView.adapter = itemAdapter

        for(contact in contactsList) {
            val contactItem = ContactItem(contact)
            itemAdapter.add(contactItem)
        }

        // Ajout de la gestion du clic sur une cellule :

        itemAdapter.withOnClickListener(object : OnClickListener<ContactItem>{
            override fun onClick(v: View?, adapter: IAdapter<ContactItem>?, item: ContactItem?, position: Int): Boolean {

                val contact = item?.contact

                if(contact is Contact) {
                    Toast
                            .makeText(this@ContactActivity,
                                    "contact : ${contact.firstName}",
                                    Toast.LENGTH_SHORT)
                            .show()
                }



                return true
            }

        })

        // Appel au WS
        ContactService.getContacts(object: ContactService.ContactServiceListener{
            override fun onReceiveResult(contacts: List<ContactJSON>) {

                itemAdapter.clear() // nettoyage de la liste avant de la remplir

                // Remplissage de l'adapter à partir des objets ContactJSON, retransformé en Contact -> ContactItem
                for(contactJSON in contacts) {
                    itemAdapter.add(ContactItem(Contact(contactJSON.name.first, contactJSON.name.last)))
                }
            }

            override fun onFailed() {

            }

        })



    }
}
