package com.example.furnicart

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SuccessOrder : AppCompatActivity() {

    lateinit var btnTrackOrders:Button
    lateinit var btnBackHome:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_success_order)

        btnTrackOrders = findViewById(R.id.btnTrackOrders)
        btnBackHome = findViewById(R.id.btnBackHome)

        btnTrackOrders.setOnClickListener(){

            
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}