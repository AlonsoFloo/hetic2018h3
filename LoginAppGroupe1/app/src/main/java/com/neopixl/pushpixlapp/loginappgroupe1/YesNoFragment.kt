package com.neopixl.pushpixlapp.loginappgroupe1


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

/**
 * A simple [Fragment] subclass.
 *
 */
class YesNoFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance(callback: (Boolean) -> Unit) =
                YesNoFragment().apply {
                    this.callback = callback
                    arguments = Bundle().apply {
                    }
                }

        @JvmStatic
        fun newInstance(listener: YesNoListener) =
                YesNoFragment().apply {
                    this.listener = listener
                    arguments = Bundle().apply {
                    }
                }
    }

    lateinit var callback: (Boolean) -> Unit
    var listener: YesNoListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_yes_no, container, false)
    }

    override fun onStart() {
        super.onStart()

        val okButton = this.view?.findViewById<Button>(R.id.okButton)
        val notOkButton = this.view?.findViewById<Button>(R.id.notOkButton)


        okButton?.setOnClickListener {
            // USER IS OK
            callback(true)
            if (listener != null) {
                listener?.didTapOnOk()
            }
        }
        notOkButton?.setOnClickListener {
            // USER IS NOT OK
            callback(false)
            if (listener != null) {
                listener?.didTapOnCancel()
            }
        }
    }



}
