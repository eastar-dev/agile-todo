package com.bestuna.todo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bestuna.todo.data.Todo
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

open class CreateFragment : Fragment() {

    val vm : MainActivityViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_create, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<MaterialButton>(R.id.btn_add).setOnClickListener {

            if (checkValidation(view.findViewById<TextInputEditText>(R.id.input_title).text.toString(), view.findViewById<TextInputEditText>(R.id.input_content).text.toString())) {

                val newTodo = Todo(
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

    override fun onDetach() {
        super.onDetach()
        (activity as MainActivity).findViewById<FloatingActionButton>(R.id.fab).isVisible = true
    }

    fun checkValidation(title: String, content: String): Boolean = !(title.isBlank() || content.isBlank())

}

