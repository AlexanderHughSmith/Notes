package com.zanhsmitty.notes.ui.screens.login

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zanhsmitty.notes.useCases.login.LoginFormEvent
import com.zanhsmitty.notes.useCases.login.LoginFormState
import com.zanhsmitty.notes.ui.composables.CustomTextField
import com.zanhsmitty.notes.ui.screens.SharedViewModel

@ExperimentalMaterial3Api
@Composable
fun LoginScreen(
    sharedViewModel: SharedViewModel
) {
    LoginContent(
        formState = sharedViewModel.loginFormState,
        onEvent = { sharedViewModel.onLoginFormEvent(it) }
    )
}