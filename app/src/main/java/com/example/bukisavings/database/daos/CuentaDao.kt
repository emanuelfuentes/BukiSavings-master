package com.example.bukisavings.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.bukisavings.database.entities.Cuenta

@Dao
interface CuentaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserCuenta(cuenta: Cuenta)
    @Query("select * from cuenta where user_id =:id")
    fun getAccountsOf(id:Long):LiveData<List<Cuenta>>
}