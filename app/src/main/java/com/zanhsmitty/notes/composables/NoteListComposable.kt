package com.zanhsmitty.notes.composables

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import com.zanhsmitty.notes.Screen
import com.zanhsmitty.notes.ui.screens.SharedViewModel
import com.zanhsmitty.notes.ui.screens.note.list.NoteListScreen

@ExperimentalMaterial3Api
@ExperimentalAnimationApi
fun NavGraphBuilder.noteListComposable(
    sharedViewModel: SharedViewModel,
    navigateTo: (String) -> Unit
){
    composable(
        route = Screen.NoteList.route
    ) {
        NoteListScreen(
            sharedViewModel = sharedViewModel,
            navigateTo = navigateTo
        )
    }
}