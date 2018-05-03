package com.neopixl.pushpixlapp.loginappgroupe2


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



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_yes_no, container, false)
    }








    companion object {
        @JvmStatic
        fun newInstance(theNewListener: YesNoListener) =
                YesNoFragment().apply {
                    this.listener = theNewListener
                    arguments = Bundle().apply {
                    }
                }
    }

    private var listener: YesNoListener? = null

    override fun onStart() {
        super.onStart()

        val okButton = this.view?.findViewById<Button>(R.id.okButton)
        val cancelButton = this.view?.findViewById<Button>(R.id.cancelButton)


        okButton?.setOnClickListener {
            if (listener != null) {
                listener?.didSayYes()
            }
        }

        cancelButton?.setOnClickListener {
            if (listener != null) {
                listener?.didCancel()
            }
        }
    }


}
