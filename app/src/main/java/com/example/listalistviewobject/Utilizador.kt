package com.example.listalistviewobject

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "utilizadores")
data class Utilizador(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    var username: String,
    var password: String
)