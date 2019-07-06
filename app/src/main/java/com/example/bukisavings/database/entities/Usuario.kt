package com.example.bukisavings.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuarios")
data class Usuario(
    val usuario:String,
    val clave:String
) {
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0
}