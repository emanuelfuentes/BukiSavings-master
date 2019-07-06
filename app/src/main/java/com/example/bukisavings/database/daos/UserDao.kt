package com.example.bukisavings.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.bukisavings.database.entities.Usuario

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user:Usuario):Long

    @Query("select * from usuarios where usuario=:user and clave = :pass")
    fun getUser(user:String,pass:String):LiveData<Usuario>

    @Query("select * from usuarios where id=:id")
    fun getUser(id:Long):LiveData<Usuario>

}