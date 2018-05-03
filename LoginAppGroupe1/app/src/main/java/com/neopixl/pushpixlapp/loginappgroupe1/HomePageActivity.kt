package com.neopixl.pushpixlapp.loginappgroupe1

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home_page.*

class HomePageActivity : AppCompatActivity(), YesNoListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val yesNoFragment = YesNoFragment.newInstance({ isOk ->
            if (isOk) {
                val informationToAnswer = Intent()
                informationToAnswer.putExtra("email", "florian@neopixl.com")
                setResult(Activity.RESULT_OK, informationToAnswer);
            } else {
                setResult(Activity.RESULT_CANCELED);
            }
            finish()
        })

        supportFragmentManager.beginTransaction()
                .add(R.id.yesNoContainer, yesNoFragment)
                //.addToBackStack("yesNo")
                // remove || replace
                .commit()



        //YesNoFragment.newInstance(this)

    }

    override fun didTapOnOk() {

    }

    override fun didTapOnCancel() {

    }


}
