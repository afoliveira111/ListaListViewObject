package com.example.listalistviewobject

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UtilizadorDao {
    @Query("SELECT * FROM utilizadores")
    suspend fun getAllUtilizadores(): List<Utilizador>

    @Insert
    suspend fun insertUtilizador(utilizador: Utilizador)

    @Update
    suspend fun updateUtilizador(utilizador: Utilizador)

    @Delete
    suspend fun deleteUtilizador(utilizador: Utilizador)
}