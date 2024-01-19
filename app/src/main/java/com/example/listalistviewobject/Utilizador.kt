package com.example.listalistviewobject

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "utilizadores")
class Utilizador(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    var username: String,
    var password: String
) {
    override fun toString(): String {
        return username
    }
}