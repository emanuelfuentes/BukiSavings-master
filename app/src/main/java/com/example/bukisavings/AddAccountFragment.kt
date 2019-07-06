package com.example.bukisavings


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bukisavings.adapters.AccountAdapter
import com.example.bukisavings.database.entities.Cuenta
import com.example.bukisavings.viewmodels.UsuarioViewModel
import kotlinx.android.synthetic.main.fragment_add_account.view.*


class AddAccountFragment : Fragment() {
    lateinit var myView: View
    lateinit var userViewModel: UsuarioViewModel
    lateinit var accountAdapter: AccountAdapter
    lateinit var fragmentHelper: FragmentHelper

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentHelper = context as FragmentHelper
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userViewModel = ViewModelProviders.of(this).get(UsuarioViewModel::class.java)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_add_account, container, false)
        accountAdapter = object : AccountAdapter() {
            override fun setClickListener(itemView: View, patient: Cuenta) {
                Toast.makeText(myView.context, "Clicked", Toast.LENGTH_SHORT).show()
            }

        }
        userViewModel.getAccountsOf(fragmentHelper.getUserId()).observe(this, Observer {
            accountAdapter.updateList(it)
        })
        myView.bt_add_account.setOnClickListener {
            val nextAction = AddAccountFragmentDirections.actionDestinationAccountToDestinationAccountInfo()
//            nextAction.accountId = fragmentHelper.getUserId()
            Navigation.findNavController(myView).navigate(nextAction)

        }
        myView.rv_list_account.apply {
            setHasFixedSize(true)
            adapter = accountAdapter
            layoutManager = LinearLayoutManager(myView.context)
        }
        return myView
    }


}
