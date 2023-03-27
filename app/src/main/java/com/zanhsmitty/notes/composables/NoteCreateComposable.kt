package com.zanhsmitty.notes.composables

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import com.zanhsmitty.notes.Screen
import com.zanhsmitty.notes.ui.screens.SharedViewModel
import com.zanhsmitty.notes.ui.screens.note.create.NoteCreateScreen

@ExperimentalAnimationApi
@ExperimentalMaterial3Api
fun NavGraphBuilder.noteCreateComposable(
    sharedViewModel: SharedViewModel
){
    composable(
        route = Screen.NoteCreate.route
    ) {
        NoteCreateScreen(
            sharedViewModel = sharedViewModel
        )
    }
}