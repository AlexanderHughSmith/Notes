package com.zanhsmitty.notes.ui.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zanhsmitty.notes.useCases.login.LoginFormEvent
import com.zanhsmitty.notes.useCases.login.LoginFormState
import com.zanhsmitty.notes.ui.composables.CustomTextField
import com.zanhsmitty.notes.ui.theme.NotesTheme

@ExperimentalMaterial3Api
@Composable
fun LoginContent(
    modifier: Modifier,
    formState: LoginFormState,
    onEvent: (LoginFormEvent) -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
    ){
        CustomTextField(
            modifier = Modifier.fillMaxWidth(),
            value = formState.email,
            onValueChange = { onEvent(LoginFormEvent.EmailChanged(it)) },
            label = "Email",
            error = formState.emailError
        )
        CustomTextField(
            modifier = Modifier.fillMaxWidth(),
            value = formState.password,
            onValueChange = { onEvent(LoginFormEvent.PasswordChanged(it)) },
            label = "Password",
            error = formState.passwordError
        )
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onEvent(LoginFormEvent.LoginClicked)
            }
        ) {
            Text(text = "Login")
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun LoginContentPreview() {
    NotesTheme {
        LoginContent(
            modifier = Modifier,
            formState = LoginFormState(),
            onEvent = { }
        )
    }
}