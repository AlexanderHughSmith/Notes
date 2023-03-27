package com.zanhsmitty.notes.useCases.note

sealed class NoteFormEvent {
    data class TitleChanged(val title: String) : NoteFormEvent()
    data class DescriptionChanged(val description: String) : NoteFormEvent()
    object CreateClicked : NoteFormEvent()
}