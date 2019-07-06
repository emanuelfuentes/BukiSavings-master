package com.example.bukisavings.repositories

import androidx.annotation.WorkerThread
import com.example.bukisavings.database.daos.UserDao
import com.example.bukisavings.database.entities.Usuario

class UserRepository (private val userDao: UserDao){
    @WorkerThread
   suspend fun insertUser(user:Usuario) = userDao.insertUser(user)
    fun getUser(user: String, pass: String) = userDao.getUser(user, pass)
    fun getUser(id:Long) = userDao.getUser(id)
}
