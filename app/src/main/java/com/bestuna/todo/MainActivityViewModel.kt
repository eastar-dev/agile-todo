package com.bestuna.todo

import android.content.Context
import android.log.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bestuna.todo.data.Todo
import com.bestuna.todo.repo.TodoRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch

class MainActivityViewModel @ViewModelInject constructor(
    @ApplicationContext private val appContext: Context,
    val repository: TodoRepository,
    @Assisted private val savedStateHandle: SavedStateHandle,
) : ViewModel() {
    //01
    val todos = MutableLiveData<List<Todo>>()
    //02
    init {
        Log.e("MainActivityViewModel")
        getTodos()
    }

    private fun getTodos() {
        Log.e(appContext)
        Log.e(savedStateHandle)

        viewModelScope.launch {
            val todos = repository.getTodos()
            Log.e(todos)
            this@MainActivityViewModel.todos.value = todos
        }
    }
}
