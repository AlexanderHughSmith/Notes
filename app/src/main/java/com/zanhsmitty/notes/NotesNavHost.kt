package com.zanhsmitty.notes

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.zanhsmitty.notes.composables.loginComposable
import com.zanhsmitty.notes.composables.noteCreateComposable
import com.zanhsmitty.notes.composables.noteListComposable
import com.zanhsmitty.notes.ui.screens.SharedViewModel

@ExperimentalMaterial3Api
@ExperimentalAnimationApi
@Composable
fun NotesNavHost(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
   AnimatedNavHost(
       navController = navController,
       startDestination = Screen.Login.route
   ){
         loginComposable(
              sharedViewModel = sharedViewModel,
                navigateTo = { route ->
                     navController.navigate(route)
                }
         )
         noteListComposable(
              sharedViewModel = sharedViewModel,
                navigateTo = { route ->
                     navController.navigate(route)
                }
         )
         noteCreateComposable(
              sharedViewModel = sharedViewModel
         )
   }
}