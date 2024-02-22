package com.example.akbar_atakhodzhaev_m3_hw5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myButton: Button = findViewById(R.id.buttonChange)
        val myTextView: TextView = findViewById(R.id.zero)

        var currentValue = 0

        myButton.setOnClickListener {
            if (myButton.text == "+1") {
                currentValue++
                myTextView.text = currentValue.toString()

                if (currentValue == 10) {
                    myButton.text = "-1"
                }
            } else {
                currentValue--
                myTextView.text = currentValue.toString()

                if (currentValue == 0) {
                    myButton.visibility = View.GONE
                    myTextView.visibility = View.GONE
                    val myFragment = MainFragment()
                    val fragmentManager = supportFragmentManager
                    val transaction = fragmentManager.beginTransaction()
                    transaction.replace(R.id.mainActivityContainer, myFragment)
                    transaction.commit()
                }
            }
        }
    }
}
