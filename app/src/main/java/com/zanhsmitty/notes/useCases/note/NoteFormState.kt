package com.zanhsmitty.notes.useCases.note

data class NoteFormState(
    val title: String = "",
    val titleError: String? = null,
    val description: String = "",
    val descriptionError: String? = null,
)
