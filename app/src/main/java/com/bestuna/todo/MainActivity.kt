package com.bestuna.todo

import android.log.Log
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {

    val vm: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
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
}
