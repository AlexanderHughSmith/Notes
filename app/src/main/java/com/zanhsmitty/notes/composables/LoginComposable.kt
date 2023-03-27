package com.zanhsmitty.notes.composables

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import com.zanhsmitty.notes.Screen
import com.zanhsmitty.notes.ui.screens.SharedViewModel
import com.zanhsmitty.notes.ui.screens.login.LoginScreen

@ExperimentalAnimationApi
@ExperimentalMaterial3Api
fun NavGraphBuilder.loginComposable(
    sharedViewModel: SharedViewModel
){
    composable(
        route = Screen.Login.route
    ) {
        LoginScreen(
            sharedViewModel = sharedViewModel
        )
    }
}