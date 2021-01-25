package com.bestuna.todo.data

import java.util.*

data class Todo(
    val id: String = UUID.randomUUID().toString(),
    val title: String = "NoTitle",
    val content: String = ""
)
