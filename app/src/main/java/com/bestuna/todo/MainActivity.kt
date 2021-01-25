package com.bestuna.todo

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bestuna.todo.data.Todo
import com.bestuna.todo.databinding.ActivityMainBinding
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {

    var adapter :TodoDisplayAdapter? = null
    lateinit var bb : ActivityMainBinding
    val vm : DisplayViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bb = DataBindingUtil.setContentView(this,R.layout.activity_main)
        bb.vm = vm

        adapter = TodoDisplayAdapter(this,mutableListOf(Todo("1","Title Test","Content Test"),Todo("2","Title Test2","Content Test2")))
        bb.todoList.adapter = adapter

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
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


    inner class TodoDisplayAdapter(var context: Context, list:MutableList<Todo>) : RecyclerView.Adapter<TodoDisplayAdapter.ToDoDisplayViewHolder>() {
        var DisplayList = list

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoDisplayViewHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.displaylist_item,parent,false)
            return ToDoDisplayViewHolder(view)
        }

        override fun onBindViewHolder(holder: ToDoDisplayViewHolder, position: Int) {
            holder.id.text = DisplayList[position].id
            holder.title.text = DisplayList[position].title
            holder.content.text = DisplayList[position].content
        }

        override fun getItemCount() = DisplayList.size

        inner class ToDoDisplayViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val title = view.findViewById<TextView>(R.id.title)
            val content = view.findViewById<TextView>(R.id.content)
            val id = view.findViewById<TextView>(R.id.id)
        }


    }
}