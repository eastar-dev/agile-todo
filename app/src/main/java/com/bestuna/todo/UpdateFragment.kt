package com.bestuna.todo

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.bestuna.todo.data.Todo

class UpdateFragment : CreateFragment() {
    lateinit var todo: Todo
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = requireArguments().getString(EXTRA_ID)!!
        todo = TodoDB.get(id)
        view.findViewById<EditText>(R.id.input_title).setText(todo.title)
        view.findViewById<EditText>(R.id.input_content).setText(todo.content)
        view.findViewById<TextView>(R.id.tv_head).text = "Update"
        view.findViewById<TextView>(R.id.btn_add).text = "Update"

        (activity as MainActivity).findViewById<Toolbar>(R.id.toolbar).title = "Update"
    }

    companion object {
        const val EXTRA_ID = "extra_id"
    }
}