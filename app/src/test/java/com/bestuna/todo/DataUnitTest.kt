package com.bestuna.todo

import com.bestuna.todo.data.Todo
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class DataUnitTest {
    @Test
    fun data_test() {
        val item = Todo(title = "title", content = "content")
        println(item)
        assertTrue(item.id.length == "a000fc87-703b-4006-92b3-df411a9e32bd".length)
        assertTrue(item.title == "title")
        assertTrue(item.content == "content")
    }

    @Test(expected = NullPointerException::class)
    fun data_test_NullPointerException() {
        throw  NullPointerException()
    }
}