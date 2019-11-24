package com.projeto.myd.reciclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.projeto.myd.R
import kotlinx.android.synthetic.main.layout_notificacao_list_item.view.*

class NotificacaoRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private lateinit var itens: List<String>

    fun submitList(lista: List<String>){
        itens = lista
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NotificacaoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_notificacao_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is NotificacaoViewHolder -> {
                holder.bind(itens.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return itens.size
    }

    class NotificacaoViewHolder constructor(
        itemView : View
    ): RecyclerView.ViewHolder(itemView){

        val textoView:TextView = itemView.textoNotificacao

        fun bind(texto: String){
            textoView.setText(texto)
        }
    }

}