package com.example.bukisavings.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.bukisavings.Helper
import com.example.bukisavings.database.RoomDb
import com.example.bukisavings.database.entities.Cuenta
import com.example.bukisavings.database.entities.Usuario
import com.example.bukisavings.repositories.CuentaRepository
import com.example.bukisavings.repositories.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class UsuarioViewModel (private val app: Application) : AndroidViewModel(app){
    private val userRepo:UserRepository
    private val cuentaRepo:CuentaRepository
    init {
        val userDao = RoomDb.getInstance(app).userDao()
        val cuentaDao = RoomDb.getInstance(app).cuentaDao()
        userRepo = UserRepository(userDao)
        cuentaRepo = CuentaRepository(cuentaDao)
    }

    fun getUser(id:Long) = userRepo.getUser(id)

    fun insertUser(user:Usuario,helper:Helper) = viewModelScope.launch(Dispatchers.IO) {
        try{
            userRepo.insertUser(user)
            withContext(Dispatchers.Main){
                helper.showToast("Operacion Exitosa")
            }

        }catch (e:Exception){
            withContext(Dispatchers.Main){
                helper.showToast("Operacion Salio Mal")
            }
        }
    }
    fun getUser(user:String,pass:String) = userRepo.getUser(user,pass)

    fun inserCuentaUsuario(cuenta:Cuenta,helper: Helper) = viewModelScope.launch(Dispatchers.IO){
        try{
            cuentaRepo.inserCuenta(cuenta)

            withContext(Dispatchers.Main){
                helper.showToast("Operacion Exitosa")
            }

        }catch (e:Exception){
            withContext(Dispatchers.Main){
                helper.showToast("Operacion Salio Mal")
                Log.e("CUSTOM",e.toString())
            }
        }
    }
    fun getAccountsOf(id:Long) = cuentaRepo.getAccountsOf(id)
}