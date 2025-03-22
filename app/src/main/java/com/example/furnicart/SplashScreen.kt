package com.example.furnicart

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Delay for 3 seconds before transitioning to the next activity
        android.os.Handler(Looper.getMainLooper()).postDelayed({
            // Intent to navigate to the next activity
            val intent = Intent(this, Onbord_screen01::class.java)
            startActivity(intent)
            finish() // Finish the splash screen activity so it cannot be returned to
        }, 3000) // 3000 milliseconds = 3 seconds


    }
}