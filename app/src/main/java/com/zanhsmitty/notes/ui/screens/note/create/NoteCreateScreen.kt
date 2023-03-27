package com.zanhsmitty.notes.ui.screens.note.create

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import com.zanhsmitty.notes.ui.screens.SharedViewModel

@ExperimentalMaterial3Api
@Composable
fun NoteCreateScreen(
    sharedViewModel: SharedViewModel
) {
    NoteCreateContent(
        noteFormState = sharedViewModel.noteFormState,
        onEvent = { sharedViewModel.onNoteFormEvent(it) }
    )
}