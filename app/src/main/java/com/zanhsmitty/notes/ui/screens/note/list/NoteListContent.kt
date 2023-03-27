package com.zanhsmitty.notes.ui.screens.note.list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.zanhsmitty.notes.domain.dto.Note
import com.zanhsmitty.notes.ui.screens.note.extras.NoteListItem
import com.zanhsmitty.notes.ui.theme.NotesTheme

@Composable
fun NoteListContent(
    notes: List<Note>,
) {
    LazyColumn(){
        items(notes){note ->
            NoteListItem(note = note)
        }
    }
}

@Preview
@Composable
fun NoteListContentPreview() {
    NotesTheme {
        NoteListContent(notes = Note.tempList)
    }
}