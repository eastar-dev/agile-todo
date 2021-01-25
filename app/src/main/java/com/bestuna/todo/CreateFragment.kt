package com.bestuna.todo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bestuna.todo.data.Todo
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

open class CreateFragment : Fragment() {

    val vm: CreateTodoViewmodel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<MaterialButton>(R.id.btn_add).setOnClickListener {
            Snackbar.make(view, "Todo내용 저장 할거얌. ", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

            val newTodo = Todo(title = view.findViewById<TextInputEditText>(R.id.input_title).text.toString(), content = view.findViewById<TextInputEditText>(R.id.input_content).text.toString())
            vm.addTodo(newTodo)
            Log.e("생성된 Todo 객체", newTodo.toString())
            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
            activity?.supportFragmentManager?.popBackStack()
            (activity as MainActivity).findViewById<FloatingActionButton>(R.id.fab).isVisible = true
        }

    }

    override fun onDetach() {
        super.onDetach()
        (activity as MainActivity).findViewById<FloatingActionButton>(R.id.fab).isVisible = true
    }

}

