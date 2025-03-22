package com.example.furnicart

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.furnicart.models.FormData
import com.example.furnicart.models.MyCredentials
import com.example.furnicart.models.validations.ValidationResult

class Login : AppCompatActivity() {

    lateinit var username: EditText
    lateinit var password: EditText

    //private var count = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        username = findViewById(R.id.username)
        password = findViewById(R.id.password)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun displayAlert(title: String, message: String, onPositiveClick: (() -> Unit)? = null) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("OK") { _, _ ->
            onPositiveClick?.invoke() // Executes the callback if provided
        }
        val dialog = builder.create()
        dialog.show()
    }


    fun login(v: View) {
        val myForm = FormData(
            username.text.toString(),
            password.text.toString()
        )

        val usernameValidation = myForm.validateUsername()
        val passwordValidation = myForm.validatePassword()

        // Reset errors
        username.error = null
        password.error = null

        var count = 0 // Reset count for each login attempt


        when (usernameValidation) {
            is ValidationResult.Valid -> {
                count++
            }

            is ValidationResult.Invalid -> {
                username.error = usernameValidation.errorMessage
            }

            is ValidationResult.Empty -> {
                username.error = usernameValidation.errorMessage
            }


        }

        when (passwordValidation) {
            is ValidationResult.Valid -> {
                count++
            }

            is ValidationResult.Invalid -> {
                password.error = passwordValidation.errorMessage
            }

            is ValidationResult.Empty -> {
                password.error = passwordValidation.errorMessage
            }


        }

        /* if(count == 2) ){


                    displayAlert("Success", "${username.text}, You have successfully logged in") {
                        val name = username.text.toString()
                        val intent = Intent(this, Home::class.java)
                        intent.putExtra("USER_NAME", name)
                        startActivity(intent)
                    }
                */
        if (count == 2 && username.text.toString() == MyCredentials.username && MyCredentials.getPassword(
                password.text.toString()
            )
        ) {


            displayAlert("Success", "${username.text}, You have successfully logged in") {
                val name = username.text.toString()
                val intent = Intent(this, Home::class.java)
                intent.putExtra("USER_NAME", name)
                startActivity(intent)
            }
        } else {

            if (count != 2) {
                Toast.makeText(this, "Check all the input fields!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Invalid Credentials!", Toast.LENGTH_SHORT).show()
            }


        }

    }


        fun Signup(view: View){

            val intent = Intent(this,Register::class.java)

            startActivity(intent)
        }

}