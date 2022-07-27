package com.example.android.architecture.blueprints.todoapp.tasks

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.architecture.blueprints.todoapp.getOrAwaitValue
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsNot.not
import org.hamcrest.core.IsNull.nullValue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class TasksViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun addNewTask_setsNewTaskEvent() {

        val tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())

        tasksViewModel.addNewTask()

        val value = tasksViewModel.newTaskEvent.getOrAwaitValue()

        assertThat(value.getContentIfNotHandled(), not(nullValue()))
    }
}