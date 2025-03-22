package com.example.furnicart.models

import com.example.furnicart.models.validations.ValidationResult

class FormData (
    private var username:String,
    private var password:String,
    //private var rePassword: String? = null, // Optional for registration
   // private var email: String? = null,     // Optional for registration


) {
    fun validateUsername(): ValidationResult {

        return if (username.isEmpty()) {
            ValidationResult.Empty("Enter the User Name")
        } else
            ValidationResult.Valid
    }

    fun validatePassword(): ValidationResult {

        return if (password.isEmpty()) {
            ValidationResult.Empty("Enter the Password")
        } else if (password.length != 8) {
            ValidationResult.Invalid("Password must be 8 characters.")

        } else
            ValidationResult.Valid
    }
/*
    fun validateRePassword(): ValidationResult {
        return if (rePassword.isEmpty()) {
            ValidationResult.Empty("Please re-enter the password")
        } else if (rePassword != password) {
            ValidationResult.Invalid("Passwords do not match")
        } else
            ValidationResult.Valid

    }

    fun validateEmail(): ValidationResult {
        return when {

            email.isEmpty() -> ValidationResult.Empty("Enter the Email")
            !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() ->
                ValidationResult.Invalid("Invalid email format")
            else -> ValidationResult.Valid
        }
    }
*/
}


