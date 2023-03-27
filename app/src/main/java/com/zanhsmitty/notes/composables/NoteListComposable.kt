package com.zanhsmitty.notes.composables

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import com.zanhsmitty.notes.Screen
import com.zanhsmitty.notes.ui.screens.SharedViewModel
import com.zanhsmitty.notes.ui.screens.note.list.NoteListScreen

@ExperimentalAnimationApi
fun NavGraphBuilder.noteListComposable(
    sharedViewModel: SharedViewModel
){
    composable(
        route = Screen.NoteList.route
    ) {
        NoteListScreen(
            sharedViewModel = sharedViewModel
        )
    }
}