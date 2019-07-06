package com.example.bukisavings


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.bukisavings.database.entities.Usuario
import com.example.bukisavings.viewmodels.UsuarioViewModel
import kotlinx.android.synthetic.main.fragment_registro.view.*


class RegistroFragment : Fragment(),Helper {
    lateinit var myView:View
    override fun showToast(msg: String) {
        Toast.makeText(myView.context,msg,Toast.LENGTH_SHORT).show()
    }

    lateinit var userViewModel: UsuarioViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userViewModel = ViewModelProviders.of(this).get(UsuarioViewModel::class.java)

    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        myView =  inflater.inflate(R.layout.fragment_registro, container, false)
        myView.bt_register_reg.setOnClickListener {
            if(myView.et_register_usr.text.toString().isNotBlank() &&myView.et_register_pass.text.toString().isNotBlank() ){
                userViewModel.insertUser(Usuario(myView.et_register_usr.text.toString(),myView.et_register_pass.text.toString()),this)

            }
        }
        return myView
    }


}
