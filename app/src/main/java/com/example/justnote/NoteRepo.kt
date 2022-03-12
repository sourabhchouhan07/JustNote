package com.example.justnote

import androidx.lifecycle.LiveData

class NoteRepo(private val noteDao: TodoDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allNotes: LiveData<List<TodoModel>> = noteDao.getTask()

    suspend fun insert(todoModel: TodoModel){
        noteDao.insertTask(todoModel)
    }
    suspend fun update(todoModel: TodoModel){
        noteDao.update(todoModel)
    }


}