package com.example.justnote

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TodoDao {

    @Insert()
    suspend fun insertTask(todoModel: TodoModel):Long

    @Update
    suspend fun update(todoModel: TodoModel):Long

    @Query("Select * from TodoModel where isFinished == 0")
    fun getTask():LiveData<List<TodoModel>>

    @Query("Update TodoModel Set isFinished = 1 where id=:uid")
    fun finishTask(uid:Long)

    @Query("Delete from TodoModel where id=:uid")
    fun deleteTask(uid:Long)
}