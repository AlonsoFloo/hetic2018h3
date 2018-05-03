package com.neopixl.pushpixlapp.loginappgroupe2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        loginButton.setOnClickListener {

            Toast.makeText(this,
                    "CLICKED ON BUTTON",
                    Toast.LENGTH_SHORT)
                    .show()

            tryToLogin()
        }
    }

    fun tryToLogin() {
        val email = emailEditText.text
        val password = passwordEditText.text


        if (!email.isEmpty() && !password.isEmpty()) {
            // SUCCESS

            val greenColor = getColor(R.color.green)
            helloTextView.setTextColor(greenColor)
            helloTextView.text = getString(R.string.success)

        } else {
            // DISPLAY ERROR

            val redColor = getColor(R.color.red)
            helloTextView.setTextColor(redColor)
            helloTextView.text = getString(R.string.error_empty)


            val builder = AlertDialog.Builder(this)
                    .setTitle("Mon titre")
                    .setMessage("Mon message")
                    .setNegativeButton("NON", { view, which ->

                    })

            val dialog = builder.create()
            dialog.show()

        }
    }
}
