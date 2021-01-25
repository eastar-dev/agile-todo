package com.bestuna.todo

import android.log.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bestuna.todo.data.Todo

class CreateTodoViewmodel: ViewModel() {

    val title = MutableLiveData<String>()
    val content = MutableLiveData<String>()

    fun createTodo(title: String, content: String) {
        val todo = Todo(title = title, content = content)
    }

    fun addTodo(todo: Todo) {
        Log.e("새로 생성된 todo", todo)
    }
}