package com.bestuna.todo.repo

import com.bestuna.todo.data.Todo


interface TodoRepository {
    suspend fun getTodos(): List<Todo>
}


