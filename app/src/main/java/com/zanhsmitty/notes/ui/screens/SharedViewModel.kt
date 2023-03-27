package com.zanhsmitty.notes.ui.screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.zanhsmitty.notes.Screen
import com.zanhsmitty.notes.useCases.login.LoginFormEvent
import com.zanhsmitty.notes.useCases.login.LoginFormState
import com.zanhsmitty.notes.useCases.note.NoteFormEvent
import com.zanhsmitty.notes.useCases.note.NoteFormState

class SharedViewModel: ViewModel() {
    var navigateString: String = ""
        private set
    fun resetNavigateString() {
        navigateString = ""
    }
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
                signUpWithEmail(
                    email = loginFormState.email,
                    password = loginFormState.password
                )
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

    /*---------- Auth Start --------*/
    private val auth = FirebaseAuth.getInstance()

    val currentUser = MutableLiveData<FirebaseUser?>()

    fun login(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    currentUser.postValue(auth.currentUser)
                    Log.d("TAG", "login: ${auth.currentUser?.uid}")
                } else {
                    Log.d("TAG", "login: ${task.exception}")
                    // handle login error
                }
            }
    }

    fun signUpWithEmail(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Signup successful, handle the new user account here
                    val user = task.result?.user
                    login(email, password)
                } else {
                    // Signup failed, handle the error here
                    val exception = task.exception
                    Log.d("TAG", "signUpWithEmail: $exception")
                }
            }
    }

    fun getCurrentUser() {
        currentUser.postValue(auth.currentUser)
    }

    fun logout() {
        auth.signOut()
        currentUser.postValue(null)
    }

    fun checkIfUserIsLoggedIn() {
        if (auth.currentUser != null) {
            currentUser.postValue(auth.currentUser)
            navigateString = Screen.NoteList.route
        }
    }
    /*---------- Auth End --------*/
}