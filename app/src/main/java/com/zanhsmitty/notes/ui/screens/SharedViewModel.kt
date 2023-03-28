package com.zanhsmitty.notes.ui.screens

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.zanhsmitty.notes.Screen
import com.zanhsmitty.notes.domain.dto.Note
import com.zanhsmitty.notes.useCases.login.LoginFormEvent
import com.zanhsmitty.notes.useCases.login.LoginFormState
import com.zanhsmitty.notes.useCases.note.NoteFormEvent
import com.zanhsmitty.notes.useCases.note.NoteFormState

class SharedViewModel: ViewModel() {
    var navigateString by mutableStateOf("")
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
                //signUpWithEmail(
                login(
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
                createNote(
                    title = noteFormState.title,
                    description = noteFormState.description
                )
            }
        }
    }

    private val _notes = MutableLiveData<List<Note>>()
    val notes: LiveData<List<Note>> = _notes

    fun fetchNotes() {
        val notesRef = database.getReference("notes")

        // Query the notes for the current user and add a listener to update the UI
        notesRef.orderByChild("userId").equalTo(auth.currentUser!!.uid).addValueEventListener(object :
            ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val notes = mutableListOf<Note>()
                for (noteSnapshot in snapshot.children) {
                    val note = noteSnapshot.getValue(Note::class.java)
                    if (note != null) {
                        notes.add(note)
                    }
                }
                _notes.value = notes
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e(TAG, "Failed to fetch notes", error.toException())
            }
        })
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

    /*---------- Firestore Start --------*/
    val database = FirebaseDatabase.getInstance()

    fun createNote(
        title: String,
        description: String,
    ) {
        val currentUser = auth.currentUser
        if (currentUser != null) {
            val notesRef = database.reference.child("notes")
            val newNoteRef = notesRef.push()
            val newNote = Note(
                title = title,
                description = description,
                userId= currentUser.uid
            )
            newNoteRef.setValue(newNote)
        } else {
            throw Exception("User not logged in")
        }
    }

    fun onCreateButtonClicked() {
        navigateString = Screen.NoteCreate.route
    }

    fun onLogoutButtonClicked() {
        logout()
        navigateString = Screen.Login.route
    }
    /*---------- Firestore End --------*/
}