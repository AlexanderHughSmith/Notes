package com.zanhsmitty.notes.ui.screens.note.list

import androidx.compose.runtime.Composable
import com.zanhsmitty.notes.domain.dto.Note
import com.zanhsmitty.notes.ui.screens.SharedViewModel

@Composable
fun NoteListScreen(
    sharedViewModel: SharedViewModel
) {
    NoteListContent(listOf(Note.tempList[0]))
}