package com.zanhsmitty.notes.ui.screens.note.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.zanhsmitty.notes.domain.dto.Note
import com.zanhsmitty.notes.ui.screens.note.extras.NoteListItem
import com.zanhsmitty.notes.ui.theme.NotesTheme

@Composable
fun NoteListContent(
    modifier: Modifier,
    email: String,
    notes: List<Note>,
) {
    Column(
        modifier = modifier
    ){
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.primaryContainer),
            text = "Notes for $email",
            textAlign = TextAlign.Center
        )
        LazyColumn(){
            items(notes){note ->
                NoteListItem(note = note)
            }
        }
    }
}

@Preview
@Composable
fun NoteListContentPreview() {
    NotesTheme {
        NoteListContent(
            modifier = Modifier,
            email = "",
            notes = Note.tempList,
        )
    }
}