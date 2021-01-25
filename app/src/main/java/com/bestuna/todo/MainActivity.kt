package com.bestuna.todo


import android.content.Context
import android.log.Log
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.bestuna.todo.data.Todo
import com.bestuna.todo.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import dev.eastar.ktx.alert
import dev.eastar.ktx.negativeButton
import dev.eastar.ktx.positiveButton
import dev.eastar.ktx.toast

class MainActivity : AppCompatActivity() {
    private lateinit var bb: ActivityMainBinding

    val vm: MainActivityViewModel by viewModels()
    var adapter: TodoDisplayAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bb.root)
        TodoDB.CREATE(this)

        adapter = TodoDisplayAdapter(
            this,
            mutableListOf(
                Todo("1", "Title Test", "Content Test"),
                Todo("2", "Title Test2", "Content Test2")
            )
        )
        findViewById<RecyclerView>(R.id.todoList).adapter = adapter

        bb.fab.setOnClickListener { view ->
            supportFragmentManager.commit {
                replace(R.id.fragment, CreateFragment())
            }
            view.isVisible = false
            Snackbar.make(view, "Create Fragment 보일거야 ", Snackbar.LENGTH_LONG)

                .setAction("Action", null).show()
        }

        vm.todos.observe(this) {
            Log.e(it)
        }

    }

    fun maneage(todo: Todo): Unit {
        alert("삭제 혹은 수정") {
            positiveButton("수정") { edit(todo) }
            negativeButton("삭제") { delete(todo) }
        }
    }

    private fun edit(todo: Todo) {
        toast("삭제 $todo")
    }

    private fun delete(todo: Todo) {
        toast("삭제 $todo")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
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
            holder.id.text = list[position].id
            holder.title.text = list[position].title
            holder.content.text = list[position].content
        }

        override fun getItemCount() = list.size

        inner class ToDoDisplayViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            init {
                view.setOnLongClickListener {
                    maneage(list[adapterPosition])
                    true
                }
            }

            val title = view.findViewById<TextView>(R.id.title)
            val content = view.findViewById<TextView>(R.id.content)
            val id = view.findViewById<TextView>(R.id.id)
        }
    }
}