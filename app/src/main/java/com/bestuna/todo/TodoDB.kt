package com.bestuna.todo;

import android.content.Context
import android.content.SharedPreferences
import android.log.Log
import androidx.core.content.edit
import com.bestuna.todo.data.Todo
import org.json.JSONArray

object TodoDB {
    private lateinit var PREFERENCES: SharedPreferences
    fun CREATE(context: Context) {
        PREFERENCES = androidx.preference.PreferenceManager.getDefaultSharedPreferences(context)
        PREFERENCES.registerOnSharedPreferenceChangeListener { _, key ->
            Log.w(key, PREFERENCES.all[key].toString().replace("\n", "_"))
        }
    }

    fun clear() = PREFERENCES.edit(true) { clear() }
    fun contain(todo: Todo) = PREFERENCES.contains(todo.id)
    fun remove(todo: Todo) = PREFERENCES.edit(true) { remove(todo.id) }
    fun add(todo: Todo) = PREFERENCES.edit(true) {
        putString(
            todo.id, JSONArray().apply {
                put(todo.id)
                put(todo.title)
                put(todo.content)
            }.toString()
        )
    }


    @Suppress("UNCHECKED_CAST")
    fun get() = PREFERENCES.all
        .values
        .map { it as String }
        .map { JSONArray(it) }
        .map { Todo(it.getString(0)!!, it.getString(1)!!, it.getString(2)!!) }

    @Suppress("UNCHECKED_CAST")
    fun get(id: String): Todo {
        val it = PREFERENCES.all[id]
        return JSONArray(it.toString()).let {

            Todo(it.getString(0)!!, it.getString(1)!!, it.getString(2)!!)
        }
    }

    fun add(todo: List<Todo>) = todo.forEach { add(it) }
}

