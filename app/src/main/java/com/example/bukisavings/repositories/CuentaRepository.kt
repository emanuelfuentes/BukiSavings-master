package com.example.bukisavings.repositories

import androidx.annotation.WorkerThread
import com.example.bukisavings.database.daos.CuentaDao
import com.example.bukisavings.database.entities.Cuenta

class CuentaRepository (private val cuentaDao: CuentaDao){
    @WorkerThread
    suspend fun inserCuenta(cuenta:Cuenta) = cuentaDao.inserCuenta(cuenta)
    fun getAccountsOf(id:Long) = cuentaDao.getAccountsOf(id)
}