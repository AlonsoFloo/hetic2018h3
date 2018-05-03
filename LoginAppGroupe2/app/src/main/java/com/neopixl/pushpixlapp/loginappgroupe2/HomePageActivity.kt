package com.neopixl.pushpixlapp.loginappgroupe2

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home_page.*

class HomePageActivity : AppCompatActivity(), YesNoListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val yesNoFragment = YesNoFragment.newInstance(this)

        this.supportFragmentManager.beginTransaction()
                .add(R.id.yesNoContainer, yesNoFragment) // remove || replace
                //.addToBackStack("yesNo")
                .commit()
    }

    override fun didCancel() {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }

    override fun didSayYes() {
        val intent = Intent()
        intent.putExtra("email", "florian@neopixl.com")

        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
