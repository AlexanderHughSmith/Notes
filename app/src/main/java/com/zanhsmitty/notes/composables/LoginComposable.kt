package com.zanhsmitty.notes.composables

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import com.zanhsmitty.notes.Screen
import com.zanhsmitty.notes.ui.screens.SharedViewModel
import com.zanhsmitty.notes.ui.screens.login.LoginScreen

@ExperimentalAnimationApi
@ExperimentalMaterial3Api
fun NavGraphBuilder.loginComposable(
    sharedViewModel: SharedViewModel,
    navigateTo: (String) -> Unit
){
    composable(
        route = Screen.Login.route
    ) {
        LoginScreen(
            sharedViewModel = sharedViewModel,
            navigateTo = navigateTo
        )
    }
}