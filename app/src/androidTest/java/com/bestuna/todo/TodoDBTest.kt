package com.bestuna.todo

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.bestuna.todo.data.Todo
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class TodoDBTest {
    @Test
    fun todoDBCreateTest() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        TodoDB.CREATE(appContext)
    }

    @Test
    fun todoDBClearTest() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        TodoDB.CREATE(appContext)
        TodoDB.clear()
    }

    @Test
    fun todoDBAddTest() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        TodoDB.CREATE(appContext)

        TodoDB.add(Todo())
        TodoDB.add(listOf(Todo(), Todo()))
    }

    @Test
    fun todoDBGetTest() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        TodoDB.CREATE(appContext)

        todoDBAddTest()
        val todo = TodoDB.get()
        println(todo)

        Assert.assertTrue(todo.size >= 0)
        Assert.assertTrue(todo[0].title == "NoTitle")
    }
}