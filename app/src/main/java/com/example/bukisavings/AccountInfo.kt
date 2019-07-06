package com.example.bukisavings


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.bukisavings.database.entities.Cuenta
import com.example.bukisavings.viewmodels.UsuarioViewModel
import kotlinx.android.synthetic.main.fragment_account_info.view.*
import kotlinx.android.synthetic.main.fragment_add_account.view.*


class AccountInfo : Fragment(),Helper,FragmentHelper {
    override fun getUserId(): Long = fragmentHelper.getUserId()

    override fun showToast(msg: String) {
        Toast.makeText(myView.context,msg, Toast.LENGTH_SHORT).show()

    }

    lateinit var args: AccountInfoArgs
    lateinit var userViewModel: UsuarioViewModel
    lateinit var myView:View
    lateinit var fragmentHelper: FragmentHelper

    override fun onAttach(context: Context) {
        super.onAttach(context)
        userViewModel = ViewModelProviders.of(this).get(UsuarioViewModel::class.java)
        fragmentHelper = context as FragmentHelper
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_account_info, container, false)
        args = AccountInfoArgs.fromBundle(arguments!!)
        myView.bt_acinfo_aceptar.setOnClickListener {
            if(myView.et_acinfo_nombre.text.toString().isNotBlank() && myView.et_acinfo_monto.text.toString().isNotBlank()){
                val cuenta = Cuenta(myView.et_acinfo_nombre.text.toString(),fragmentHelper.getUserId())
                cuenta.monto = myView.et_acinfo_monto.text.toString().toDouble()
                userViewModel.inserCuentaUsuario(cuenta,this)
            }

        }
        return myView
    }


}
