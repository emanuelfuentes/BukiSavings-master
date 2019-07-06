package com.example.bukisavings.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "cuenta",
    foreignKeys = [ForeignKey(
        entity = Usuario::class,
        parentColumns = ["id"],
        childColumns = ["user_id"]
    )]
)
data class Cuenta(
    val nombre:String,
    val user_id:Long
){
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0
    var monto:Double = 0.0

}