package com.bestuna.todo.repo

import com.bestuna.todo.data.Todo

class TodoDataSourceRemote() : TodoDataSource {
    override suspend fun getTodos(): List<Todo> {
        TODO("Not yet implemented")
    }
}


