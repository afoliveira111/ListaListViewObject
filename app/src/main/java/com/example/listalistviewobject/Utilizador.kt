package com.example.listalistviewobject

import androidx.room.Entity
import androidx.room.PrimaryKey


class Utilizador(val username: String, val password: String){
    override fun toString(): String {
        return "Utilizador(username='$username', password='$password')"
    }
}