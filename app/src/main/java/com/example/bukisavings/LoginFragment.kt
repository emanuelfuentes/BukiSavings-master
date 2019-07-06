package com.example.bukisavings


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.example.bukisavings.viewmodels.UsuarioViewModel
import kotlinx.android.synthetic.main.fragment_login.view.*


class LoginFragment : Fragment() {

    lateinit var userViewModel:UsuarioViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userViewModel = ViewModelProviders.of(this).get(UsuarioViewModel::class.java)

    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_login, container, false)
        view.bt_login_register.setOnClickListener {
            Navigation.findNavController(view).navigate(LoginFragmentDirections.actionDestinationLoginToDestinationRegistro())
        }
        view.bt_login_log.setOnClickListener {
            if(view.et_login_usr.text.toString().isNotBlank() &&view.et_login_pass.text.toString().isNotBlank() ){
                userViewModel.getUser(view.et_login_usr.text.toString(),view.et_login_pass.text.toString()).hasActiveObservers()
                userViewModel.getUser(view.et_login_usr.text.toString(),view.et_login_pass.text.toString()).removeObservers(this)
                userViewModel.getUser(view.et_login_usr.text.toString(),view.et_login_pass.text.toString()).observe(this, Observer {
                    try{
                        if(it!=null){
                            val nextAction = LoginFragmentDirections.nextAction()
                            nextAction.userId  = it.id
                            Navigation.findNavController(view).navigate(nextAction)
                        }
                    }catch (e:Exception){
                        Log.e("ERROR",e.toString())
                    }
                })
            }

        }

        return view
    }


}
