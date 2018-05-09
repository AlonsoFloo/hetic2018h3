package com.neopixl.pushpixlapp.loginappgroupe1.fastadapter

import android.view.View
import com.mikepenz.fastadapter.items.AbstractItem
import com.neopixl.pushpixlapp.loginappgroupe1.model.Contact
import com.neopixl.pushpixlapp.loginappgroupe1.R


/**
 * Created by Florian ALONSO on 5/9/18.
 * For Neopixl
 */

class ContactItem(val contact: Contact): AbstractItem<ContactItem, ContactViewHolder>() {

    override fun getType(): Int {
        return 0
    }

    override fun getViewHolder(itemView: View?): ContactViewHolder {
        val cell = ContactViewHolder(itemView)
        return cell
    }

    override fun getLayoutRes(): Int {
        return R.layout.row_contact
    }

}