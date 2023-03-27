package com.zanhsmitty.notes

sealed class Screen(val route: String) {
    object Login: Screen("login_screen")
    object NoteList: Screen("note_list_screen")
    object NoteCreate: Screen("note_create_screen")
}