package com.example.bukisavings


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.bukisavings.viewmodels.UsuarioViewModel
import kotlinx.android.synthetic.main.fragment_user_info.view.*


class UserInfo : Fragment(), FragmentHelper {
    lateinit var fragmentHelper: FragmentHelper
    lateinit var userViewModel: UsuarioViewModel

    override fun getUserId(): Long = fragmentHelper.getUserId()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentHelper = context as FragmentHelper
        userViewModel = ViewModelProviders.of(this).get(UsuarioViewModel::class.java)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_user_info, container, false)
        userViewModel.getUser(fragmentHelper.getUserId()).observe(this, Observer {
            try {
                if (it != null) {
                    view.tv_info.text = it.usuario
                }
            } catch (e: Exception) {

            }
        })

        return view


    }
}
