package com.bestuna.todo

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.bestuna.todo.data.Todo
import com.bestuna.todo.databinding.TodoListFragmentBinding

open class TodoListFragment : Fragment() {
    private lateinit var bb: TodoListFragmentBinding
    val vm: MainActivityViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bb = TodoListFragmentBinding.inflate(inflater, container, false)
        return bb.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.todoItems.observe(viewLifecycleOwner) {
            bb.todoList.adapter = TodoDisplayAdapter(requireContext(), it)
        }
    }

    inner class TodoDisplayAdapter(var context: Context, val list: List<Todo>) :
        RecyclerView.Adapter<TodoDisplayAdapter.ToDoDisplayViewHolder>() {

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): ToDoDisplayViewHolder {
            val view =
                LayoutInflater.from(context).inflate(R.layout.displaylist_item, parent, false)
            return ToDoDisplayViewHolder(view)
        }

        override fun onBindViewHolder(holder: ToDoDisplayViewHolder, position: Int) {
//            holder.id.text = list[position].id
            holder.title.text = list[position].title
            holder.content.text = list[position].content
        }

        override fun getItemCount() = list.size

        inner class ToDoDisplayViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            init {
                view.setOnLongClickListener {
                    (activity as MainActivity).maneage(list[adapterPosition])
                    true
                }
            }

            val title = view.findViewById<TextView>(R.id.title)
            val content = view.findViewById<TextView>(R.id.content)
//            val id = view.findViewById<TextView>(R.id.id)
        }
    }
}

