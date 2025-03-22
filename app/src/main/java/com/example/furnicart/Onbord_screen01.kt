package com.example.furnicart

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Onbord_screen01 : AppCompatActivity() {

    lateinit var btnskip:Button
    lateinit var btnnext:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_onbord_screen01)

        btnnext = findViewById(R.id.btnnext)
        btnskip = findViewById(R.id.btnskip)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnnext.setOnClickListener(){


            val intent = Intent(this,Onboard_screen02::class.java)

            startActivity(intent)
        }

        btnskip.setOnClickListener(){


            val intent = Intent(this,Login::class.java)

            startActivity(intent)
        }
    }
}