package com.neopixl.pushpixlapp.loginappgroupe1

import android.app.Activity
import android.content.Intent
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
                    "Login in progress",
                    Toast.LENGTH_SHORT)
                    .show()

            tryToLogin()
        }
    }

    fun tryToLogin() {
        val email = emailEditText.text
        val password = passwordEditText.text

        if (!email.isEmpty() && !password.isEmpty()) {
            // Display success
            helloText.text = getString(R.string.success)
            val color = getColor(R.color.green)
            helloText.setTextColor(color)

            val intent = Intent(this, HomePageActivity::class.java)
            startActivityForResult(intent, 99)

        } else {
            // Display error
            helloText.text = getString(R.string.error_empty)
            helloText.setTextColor(
                    getColor(R.color.red)
            )

            val builder = AlertDialog.Builder(this@MainActivity)
            builder.setMessage("Message d'information !")
                    .setTitle("Alerte")
                    .setCancelable(true)
                    .setNegativeButton("NON", { view, which ->

                    })
                    .setPositiveButton("OUI", { view, which ->

                    })

            val dialog = builder.create()
            dialog.show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 99) {
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, "RESULT OK", Toast.LENGTH_SHORT).show()

                if (data != null) {
                    val email: String = data.extras.getString("email")
                    emailEditText.setText(email)
                }
            }
        }
    }
}
