package com.zanhsmitty.notes.ui.screens.note.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zanhsmitty.notes.domain.dto.Note
import com.zanhsmitty.notes.ui.screens.SharedViewModel

@ExperimentalMaterial3Api
@Composable
fun NoteListScreen(
    sharedViewModel: SharedViewModel,
    navigateTo: (String) -> Unit
) {
    LaunchedEffect(Unit){
        sharedViewModel.fetchNotes()
    }
    LaunchedEffect(key1 = sharedViewModel.navigateString) {
        if(sharedViewModel.navigateString.isNotEmpty()){
            navigateTo(sharedViewModel.navigateString)
            sharedViewModel.resetNavigateString()
        }
    }
    val notes by sharedViewModel.notes.observeAsState(listOf())
    Scaffold(
        topBar ={
            TopAppBar(
                title = {
                    Text(text = "Notes")
                },
                actions ={
                    IconButton(onClick = {
                        sharedViewModel.onLogoutButtonClicked()
                    }) {
                        Icon(
                            imageVector = Icons.Default.AccountBox,
                            contentDescription = "Logout"
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                sharedViewModel.onCreateButtonClicked()
            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add note"
                )
            }
        }
    ) { scaffoldPadding ->
        NoteListContent(
            modifier = Modifier
                .padding(scaffoldPadding)
                .padding(horizontal = 16.dp),
            email = sharedViewModel.currentUser.value?.email ?: "",
            notes = notes
        )
    }
}