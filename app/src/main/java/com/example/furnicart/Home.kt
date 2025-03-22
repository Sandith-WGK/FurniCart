package com.example.furnicart

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView

class Home : AppCompatActivity() {

   //lateinit var welcomeText:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        val welcomeText = findViewById<TextView>(R.id.welcomeText)

        val name = intent.getStringExtra("USER_NAME")

        if (name != null) {
            welcomeText.text = "Hi $name, get the best furniture\nfor your home"
        } else {
            welcomeText.text = "Hi Guest, get the best furniture\nfor your home"
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /*val intent = intent
        val name = intent.getStringExtra("USER_NAME")

        welcomeText.setText("Hi $name, get the best furniture\nfor your home")*/


    }

    fun Choose(view: View){

        val intent = Intent(this,Product::class.java)

        startActivity(intent)
    }

    fun Cart(v:View){

        val intent = Intent(this,Cart::class.java)

        startActivity(intent)

    }
}