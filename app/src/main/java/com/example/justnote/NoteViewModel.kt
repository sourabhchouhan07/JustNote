package com.example.justnote

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application):AndroidViewModel(application) {
    val allNotes: LiveData<List<TodoModel>>
    val repository: NoteRepo

    init{
        val dao=AppDatabase.getDatabase(application).todoDao()
        repository=NoteRepo(dao)
        allNotes=repository.allNotes
    }

    fun updateNote(todoModel: TodoModel)=viewModelScope.launch(Dispatchers.IO) {
        repository.update(todoModel)
    }
    fun insertNote(todoModel: TodoModel)=viewModelScope.launch(Dispatchers.IO) {
        repository.insert(todoModel)
    }

}