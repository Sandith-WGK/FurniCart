package com.example.furnicart

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Onboard_screen02 : AppCompatActivity() {

    lateinit var btnback: Button
    lateinit var btnnext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_onboard_screen02)

        btnnext = findViewById(R.id.btnnext)
        btnback = findViewById(R.id.btnback)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnnext.setOnClickListener(){


            val intent = Intent(this,Onboard_screen03::class.java)

            startActivity(intent)
        }

        btnback.setOnClickListener {
            finish() // This will close Onboard_screen03 and return to Onboard_screen02
        }

    }
}