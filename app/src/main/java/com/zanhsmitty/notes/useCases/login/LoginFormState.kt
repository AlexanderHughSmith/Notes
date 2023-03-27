package com.zanhsmitty.notes.useCases.login

data class LoginFormState(
    val email: String = "a@a.com",
    val emailError: String? = null,
    val password: String = "123456",
    val passwordError: String? = null,
)