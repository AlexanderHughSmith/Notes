package com.zanhsmitty.notes.ui.screens.login

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zanhsmitty.notes.useCases.login.LoginFormEvent
import com.zanhsmitty.notes.useCases.login.LoginFormState
import com.zanhsmitty.notes.ui.composables.CustomTextField
import com.zanhsmitty.notes.ui.screens.SharedViewModel

@ExperimentalMaterial3Api
@Composable
fun LoginScreen(
    sharedViewModel: SharedViewModel,
    navigateTo: (String) -> Unit
) {
    LaunchedEffect(Unit){
        sharedViewModel.checkIfUserIsLoggedIn()
    }
    LaunchedEffect(key1 = sharedViewModel.navigateString) {
        if(sharedViewModel.navigateString.isNotEmpty()){
            navigateTo(sharedViewModel.navigateString)
            sharedViewModel.resetNavigateString()
        }
    }
    LoginContent(
        modifier = Modifier.padding(20.dp),
        formState = sharedViewModel.loginFormState,
        onEvent = { sharedViewModel.onLoginFormEvent(it) }
    )
}