package com.bestuna.todo

import android.log.Log
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bb.root)
        setSupportActionBar(bb.toolbar)

        bb.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        bb.delete.setOnLongClickListener {
            maneage(Todo())
            true
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


}