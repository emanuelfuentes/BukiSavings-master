package com.example.bukisavings.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bukisavings.R
import com.example.bukisavings.database.entities.Cuenta
import kotlinx.android.synthetic.main.item_view.view.*

abstract class AccountAdapter : RecyclerView.Adapter<AccountAdapter.ViewHolder>() {
    var accountList: List<Cuenta> = emptyList()

    abstract fun setClickListener(itemView: View, patient: Cuenta)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = accountList.size

    override fun onBindViewHolder(holder: AccountAdapter.ViewHolder, position: Int) = holder.bind(accountList[position])


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.tv_item_name
        val monto = itemView.tv_item_monto
        fun bind(cuenta:Cuenta) = with(itemView) {
            this.setOnClickListener { setClickListener(itemView, cuenta) }
            name.text = cuenta.nombre
            monto.text = cuenta.monto.toString()
        }
    }

    fun updateList(list: List<Cuenta>) {
        this.accountList = list
        notifyDataSetChanged()
    }
}
