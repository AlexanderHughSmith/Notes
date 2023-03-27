package com.zanhsmitty.notes.useCases.login

sealed class LoginFormEvent {
    data class EmailChanged(val email: String) : LoginFormEvent()
    data class PasswordChanged(val password: String) : LoginFormEvent()
    object LoginClicked : LoginFormEvent()
}