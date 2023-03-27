package com.zanhsmitty.notes.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.zanhsmitty.notes.useCases.login.LoginFormEvent
import com.zanhsmitty.notes.useCases.login.LoginFormState
import com.zanhsmitty.notes.useCases.note.NoteFormEvent
import com.zanhsmitty.notes.useCases.note.NoteFormState

class SharedViewModel: ViewModel() {
    var loginFormState by mutableStateOf(LoginFormState())

    fun onLoginFormEvent(event: LoginFormEvent) {
        when(event) {
            is LoginFormEvent.EmailChanged -> {
                loginFormState = loginFormState.copy(email = event.email)
            }
            is LoginFormEvent.PasswordChanged -> {
                loginFormState = loginFormState.copy(password = event.password)
            }
            is LoginFormEvent.LoginClicked -> {

            }
        }
    }

    var noteFormState by mutableStateOf(NoteFormState())

    fun onNoteFormEvent(event: NoteFormEvent) {
        when(event) {
            is NoteFormEvent.TitleChanged -> {
                noteFormState = noteFormState.copy(title = event.title)
            }
            is NoteFormEvent.DescriptionChanged -> {
                noteFormState = noteFormState.copy(description = event.description)
            }
            is NoteFormEvent.CreateClicked -> {

            }
        }
    }
}