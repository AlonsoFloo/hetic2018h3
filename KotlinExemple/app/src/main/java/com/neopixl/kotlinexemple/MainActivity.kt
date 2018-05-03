package com.neopixl.kotlinexemple

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.util.*
import java.util.regex.Pattern
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_bottom.setTextColor(
                getColor(R.color.red)
        );
        button_bottom.visibility = View.VISIBLE
        button_bottom.text = getString(R.string.button_hello)

        button_bottom.setOnClickListener {
            Toast.makeText(
                    this@MainActivity,
                    "Click sur button",
                    Toast.LENGTH_LONG)

                    .show()
        }
    }
}