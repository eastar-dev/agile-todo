package com.bestuna.todo

import android.log.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bestuna.todo.data.Todo
import kotlin.random.Random

class MainActivityViewModel : ViewModel() {
    //01
    val todos = MutableLiveData<List<Todo>>()

    //02
    init {
        Log.e("MainActivityViewModel")
        getTodos()
    }

    private fun getTodos() {
        val rand = Random(System.currentTimeMillis())
        val todos = listOf(
            Todo(title = rand.nextInt().toString(), content = rand.nextFloat().toString()),
            Todo(title = rand.nextInt().toString(), content = rand.nextFloat().toString()),
            Todo(title = rand.nextInt().toString(), content = rand.nextFloat().toString()),
            Todo(title = rand.nextInt().toString(), content = rand.nextFloat().toString()),
            Todo(title = rand.nextInt().toString(), content = rand.nextFloat().toString()),
            Todo(title = rand.nextInt().toString(), content = rand.nextFloat().toString()),
            Todo(title = rand.nextInt().toString(), content = rand.nextFloat().toString()),
            Todo(title = rand.nextInt().toString(), content = rand.nextFloat().toString()),
            Todo(title = rand.nextInt().toString(), content = rand.nextFloat().toString()),
            Todo(title = rand.nextInt().toString(), content = rand.nextFloat().toString()),
            Todo(title = rand.nextInt().toString(), content = rand.nextFloat().toString()),
            Todo(title = rand.nextInt().toString(), content = rand.nextFloat().toString()),
        )
        Log.e(todos)
        this@MainActivityViewModel.todos.value = todos
    }

}
