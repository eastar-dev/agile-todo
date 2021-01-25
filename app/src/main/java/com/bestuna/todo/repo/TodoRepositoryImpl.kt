package com.bestuna.todo.repo

import com.bestuna.todo.data.Todo
import kotlin.random.Random


class TodoRepositoryImpl constructor(
    private val remoteDataSource: TodoDataSource,
    private val localDataSource: TodoDataSource,
): TodoRepository{
    override suspend fun getTodos(): List<Todo> {
        val rand = Random(System.currentTimeMillis())
        return listOf(
            Todo(title = rand.nextInt().toString() , content = rand.nextFloat().toString() ),
            Todo(title = rand.nextInt().toString() , content = rand.nextFloat().toString() ),
            Todo(title = rand.nextInt().toString() , content = rand.nextFloat().toString() ),
            Todo(title = rand.nextInt().toString() , content = rand.nextFloat().toString() ),
            Todo(title = rand.nextInt().toString() , content = rand.nextFloat().toString() ),
            Todo(title = rand.nextInt().toString() , content = rand.nextFloat().toString() ),
            Todo(title = rand.nextInt().toString() , content = rand.nextFloat().toString() ),
            Todo(title = rand.nextInt().toString() , content = rand.nextFloat().toString() ),
            Todo(title = rand.nextInt().toString() , content = rand.nextFloat().toString() ),
            Todo(title = rand.nextInt().toString() , content = rand.nextFloat().toString() ),
            Todo(title = rand.nextInt().toString() , content = rand.nextFloat().toString() ),
            Todo(title = rand.nextInt().toString() , content = rand.nextFloat().toString() ),
        )
    }
}


