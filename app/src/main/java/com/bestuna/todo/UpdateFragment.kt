package com.bestuna.todo

import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.bestuna.todo.data.Todo

class UpdateFragment : CreateFragment() {
    val todo: Todo = Todo()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<EditText>(R.id.input_title).setText(todo.title)
        view.findViewById<EditText>(R.id.input_content).setText(todo.content)
    }
}