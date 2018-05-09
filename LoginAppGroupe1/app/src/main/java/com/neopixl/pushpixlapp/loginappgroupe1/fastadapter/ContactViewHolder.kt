package com.neopixl.pushpixlapp.loginappgroupe1.fastadapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import com.neopixl.pushpixlapp.loginappgroupe1.R
import kotlinx.android.synthetic.main.row_contact.view.*


/**
 * Created by Florian ALONSO on 5/9/18.
 * For Neopixl
 */


class ContactViewHolder(itemView: View?): FastAdapter.ViewHolder<ContactItem>(itemView) {

    val nomTextView: TextView?
    val prenomTextView: TextView?
    val imageView: ImageView?

    init {
        nomTextView = itemView?.findViewById(R.id.nomTextView)
        prenomTextView = itemView?.findViewById(R.id.prenomTextView)
        imageView = itemView?.findViewById(R.id.imageView)
    }


    override fun unbindView(item: ContactItem?) {
        nomTextView?.setText("")
        prenomTextView?.setText("")
        imageView?.setImageDrawable(null)
    }

    override fun bindView(item: ContactItem?, payloads: MutableList<Any>?) {
        val contact = item?.contact
        nomTextView?.setText(contact?.name?.last)
        prenomTextView?.setText(contact?.email)

        if (imageView != null) {
            Glide.with(itemView.context)
                    .load(contact?.picture?.medium)
                    .into(imageView)
        }
    }


}