package com.projeto.myd.reciclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.projeto.myd.R
import com.projeto.myd.com.projeto.myd.model.Empresa
import com.projeto.myd.com.projeto.myd.model.Informacao
import kotlinx.android.synthetic.main.layout_informacoes_list_item.view.*

class InformacoesRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var items : List<Informacao> = ArrayList()
    private var empresa: Empresa? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return InfoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_informacoes_list_item, parent, false))
    }

    fun submitList(infoList: Empresa?){
        empresa = infoList
        items = infoList!!.listaDeInformacoes
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is InfoViewHolder ->{
                holder.bind(items.get(position), empresa)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class InfoViewHolder constructor(
        itemView : View
    ): RecyclerView.ViewHolder(itemView){
        val chave = itemView.chave
        val valor = itemView.valor
        val nomeEmpresa = itemView.nomeEmpresa

        fun bind(informacao: Informacao, empresa: Empresa?){
            chave.setText(informacao.key)
            valor.setText(informacao.value)
            nomeEmpresa.setText(empresa!!.razaoSocial)
        }
    }

}