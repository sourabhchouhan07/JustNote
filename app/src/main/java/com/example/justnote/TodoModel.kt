package com.example.justnote

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class TodoModel(
    var title:String,
    var description:String,
    var category: String,
    var date:Long,
    var time:Long,
    var isFinished : Int = 0,
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0
)