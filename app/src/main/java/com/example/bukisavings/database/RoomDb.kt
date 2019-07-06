package com.example.bukisavings.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bukisavings.database.daos.CuentaDao
import com.example.bukisavings.database.daos.UserDao
import com.example.bukisavings.database.entities.Cuenta
import com.example.bukisavings.database.entities.Usuario

@Database(entities = [Usuario::class,Cuenta::class], version = 2, exportSchema = false)
abstract class RoomDb: RoomDatabase() {
    abstract fun userDao():UserDao
    abstract fun cuentaDao():CuentaDao
    companion object {
        @Volatile
        private var INSTANCE: RoomDb? = null

        fun getInstance(
            context: Context
        ): RoomDb {

            if (INSTANCE != null) {
                return INSTANCE!!
            } else {
                synchronized(this) {
                    INSTANCE = Room
                        .databaseBuilder(context, RoomDb::class.java, "savings")
                        .fallbackToDestructiveMigration()
                        .build()
                    return INSTANCE!!
                }
            }
        }

    }
}