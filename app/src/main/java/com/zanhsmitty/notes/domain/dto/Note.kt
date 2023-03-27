package com.zanhsmitty.notes.domain.dto

data class Note(
    val title: String,
    val description: String,
    val userId: String
){
    companion object{
        val tempList = listOf(
            Note(
                title = "Note 1",
                description = "Description 1",
                userId = "1"
            ),
            Note(
                title = "Note 2",
                description = "Description 2",
                userId = "2"
            ),
            Note(
                title = "Note 3",
                description = "Description 3",
                userId = "3"
            ),
        )
    }
}
