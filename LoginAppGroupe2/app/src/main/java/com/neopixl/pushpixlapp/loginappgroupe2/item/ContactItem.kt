package com.neopixl.pushpixlapp.loginappgroupe2.item

import android.view.View
import android.widget.TextView
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import com.neopixl.pushpixlapp.loginappgroupe2.R
import com.neopixl.pushpixlapp.loginappgroupe2.model.Contact
import kotlinx.android.synthetic.main.row_contact.view.*

/**
 * Created by Yvan Moté on 09/05/2018.
 */

// classe qui va correspondre à un élément d'une liste
// et qui sera liée (plus tard) à une cellule (ViewHolder)
class ContactItem(var contact: Contact): AbstractItem<ContactItem, ContactItem.ContactViewHolder>() {
    override fun getType(): Int {
        // on retourne un identifiant unique pour un type de cellule
        return R.id.contactFirstNameTextView
    }

    // Méthode appelée pour créer une cellule (ex : appelée 11 fois seulement)
    override fun getViewHolder(v: View?): ContactViewHolder {
        return ContactViewHolder(v)
    }

    // On retourne la référance du layout de la cellule à charger
    // Ensuite la méthode getViewHolder sera appelée
    override fun getLayoutRes(): Int {
        return R.layout.row_contact
    }

    // classe "recyclée" correspondant à la cellule graphique (View -> row_contact)
    class ContactViewHolder: FastAdapter.ViewHolder<ContactItem> {

        private var firstNameTextView: TextView?
        private var lastNameTextView: TextView?

        constructor(view: View?) : super(view) {
            //récupération des textviews et compagnie
            firstNameTextView = view?.findViewById<TextView>(R.id.contactFirstNameTextView)

            // view?.findViewById, si view est null => findViewById retournera null

            lastNameTextView = view?.findViewById<TextView>(R.id.contactLastNameTextView)

        }

        // quand la cellule devra être recyclée
        override fun unbindView(item: ContactItem?) {
            //Nettoyage de la cellule avant ré-utilisation
            firstNameTextView?.text = null
            lastNameTextView?.text = null
        }

        // quand la cellule devra être affichée
        override fun bindView(item: ContactItem?, payloads: MutableList<Any>?) {
            // refresh UI

            val contact = item?.contact // -> Contact? => un objet Contact potentiellement nul

            firstNameTextView?.text = contact?.firstName
            lastNameTextView?.text = contact?.lastName
        }


    }

}