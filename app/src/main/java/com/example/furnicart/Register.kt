package com.example.furnicart

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.furnicart.models.MyCredentials
import com.example.furnicart.models.validations.RegFormData
import com.example.furnicart.models.validations.ValidationResult

class Register : AppCompatActivity() {

    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var rePassword: EditText
    private lateinit var email: EditText
    private lateinit var name: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)


        username = findViewById(R.id.nameTxt)
        password = findViewById(R.id.passwordTxt)
        rePassword = findViewById(R.id.passwordReEnterTxt)
        email = findViewById(R.id.emailTxt)

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



         fun register(view: View) {
            val formData = RegFormData(
                username.text.toString(),
                password.text.toString(),
                rePassword.text.toString(),
                email.text.toString()
            )

            val usernameValidation = formData.validateUsername()
            val passwordValidation = formData.validatePassword()
            val rePasswordValidation = formData.validateRePassword()
            val emailValidation = formData.validateEmail()

            // Reset errors
            username.error = null
            password.error = null
            rePassword.error = null
            email.error = null

            var validCount = 0

            when (usernameValidation) {
                is ValidationResult.Valid -> validCount++
                is ValidationResult.Empty -> username.error = usernameValidation.errorMessage
                is ValidationResult.Invalid -> username.error = usernameValidation.errorMessage
            }

            when (passwordValidation) {
                is ValidationResult.Valid -> validCount++
                is ValidationResult.Empty -> password.error = passwordValidation.errorMessage
                is ValidationResult.Invalid -> password.error = passwordValidation.errorMessage
            }

            when (rePasswordValidation) {
                is ValidationResult.Valid -> validCount++
                is ValidationResult.Empty -> rePassword.error = rePasswordValidation.errorMessage
                is ValidationResult.Invalid -> rePassword.error = rePasswordValidation.errorMessage
            }

            when (emailValidation) {
                is ValidationResult.Valid -> validCount++
                is ValidationResult.Empty -> email.error = emailValidation.errorMessage
                is ValidationResult.Invalid -> email.error = emailValidation.errorMessage
            }

            if (validCount == 4) {
                MyCredentials.username = formData.username
                MyCredentials.email = formData.email
                MyCredentials.setPassword(formData.password.toString(),formData.rePassword.toString())
                displayAlert("Success", "Registration successful!"){
                    finish()
                }

            }
            else{
                displayAlert("Failed", "Registration Failed!\n Check all the fileds.")
            }
        }

}