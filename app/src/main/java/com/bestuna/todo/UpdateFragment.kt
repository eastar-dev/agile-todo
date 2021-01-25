package com.bestuna.todo

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible
import com.bestuna.todo.data.Todo
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

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

        view.findViewById<MaterialButton>(R.id.btn_add).setOnClickListener {

            if (checkValidation(view.findViewById<TextInputEditText>(R.id.input_title).text.toString(), view.findViewById<TextInputEditText>(R.id.input_content).text.toString())) {

                val newTodo = Todo(id = todo.id,
                    title = view.findViewById<TextInputEditText>(R.id.input_title).text.toString(),
                    content = view.findViewById<TextInputEditText>(R.id.input_content).text.toString()
                )
                vm.add(newTodo)
                requireActivity().supportFragmentManager.popBackStack()
                (activity as MainActivity).findViewById<FloatingActionButton>(R.id.fab).isVisible = true
            } else {
                Snackbar.make(view, "제목과 내용을 입력해 주세요.", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

        }

    }

    companion object {
        const val EXTRA_ID = "extra_id"
    }
}