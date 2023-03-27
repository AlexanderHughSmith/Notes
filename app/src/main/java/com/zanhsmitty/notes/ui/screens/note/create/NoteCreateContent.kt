package com.zanhsmitty.notes.ui.screens.note.create

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zanhsmitty.notes.ui.composables.CustomTextField
import com.zanhsmitty.notes.ui.theme.NotesTheme
import com.zanhsmitty.notes.useCases.note.NoteFormEvent
import com.zanhsmitty.notes.useCases.note.NoteFormState

@ExperimentalMaterial3Api
@Composable
fun NoteCreateContent(
    noteFormState: NoteFormState,
    onEvent: (NoteFormEvent) -> Unit,
) {
    Column(){
        CustomTextField(
            modifier = Modifier.fillMaxWidth(),
            value = noteFormState.title,
            onValueChange = { onEvent(NoteFormEvent.TitleChanged(it)) },
            label = "Title",
            error = noteFormState.titleError
        )
        CustomTextField(
            modifier = Modifier.fillMaxWidth().height(200.dp),
            value = noteFormState.description,
            onValueChange = { onEvent(NoteFormEvent.DescriptionChanged(it)) },
            label = "Description",
            error = noteFormState.descriptionError
        )
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { onEvent(NoteFormEvent.CreateClicked) }
        ) {
            Text(text = "Save")
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun NoteCreateContentPreview() {
    NotesTheme {
        NoteCreateContent(NoteFormState(), { })
    }
}