package com.bestuna.todo

import android.log.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bestuna.todo.data.Todo

class MainActivityViewModel : ViewModel() {
    //01
    val todoItems = MutableLiveData<List<Todo>>()

    //02
    init {
        Log.e("MainActivityViewModel")
        getTodos()
    }

    private fun getTodos() {
        val todoList = TodoDB.get()
        Log.e(todoList)
        todoItems.value = todoList
    }

    fun add(todo: Todo) {
        TodoDB.add(todo)
        getTodos()
    }

    fun delete(todo: Todo) {
        TodoDB.remove(todo)
        getTodos()
    }

}
