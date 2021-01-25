package com.bestuna.todo

import android.nfc.NfcAdapter.EXTRA_ID
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.commit
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
        TodoDB.CREATE(this)
        super.onCreate(savedInstanceState)
        bb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bb.root)
        bb.toolbar.title = "ToDo List"
        bb.fab.setOnClickListener { view ->
            supportFragmentManager.commit {
                replace(R.id.fragment, CreateFragment())
                addToBackStack("createFragment")
            }
            view.isVisible = false
        }
    }

    fun maneage(todo: Todo): Unit {
        alert("삭제 혹은 수정") {
            positiveButton("수정") { edit(todo) }
            negativeButton("삭제") { delete(todo) }
        }
    }

    private fun edit(todo: Todo) {
        toast("수정 $todo")
        supportFragmentManager.commit {
            val fr = UpdateFragment().apply {
                arguments = bundleOf(UpdateFragment.EXTRA_ID to todo.id)
            }
            replace(R.id.fragment, fr)
            addToBackStack(null)
        }
        bb.fab.isVisible = false

    }

    private fun delete(todo: Todo) {
        vm.delete(todo)
    }


}