package com.bestuna.todo.repo

import com.bestuna.todo.data.Todo

interface TodoDataSource {
    suspend fun getTodos(): List<Todo>
}


