package com.zanhsmitty.notes.ui.screens.note.create

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zanhsmitty.notes.domain.dto.Note
import com.zanhsmitty.notes.ui.screens.SharedViewModel
import com.zanhsmitty.notes.ui.screens.note.list.NoteListContent

@ExperimentalMaterial3Api
@Composable
fun NoteCreateScreen(
    sharedViewModel: SharedViewModel
) {
    Scaffold() { scaffoldPadding ->
        NoteCreateContent(
            modifier = Modifier
                .padding(scaffoldPadding)
                .padding(horizontal = 16.dp),
            noteFormState = sharedViewModel.noteFormState,
            onEvent = { sharedViewModel.onNoteFormEvent(it) }
        )
    }
}