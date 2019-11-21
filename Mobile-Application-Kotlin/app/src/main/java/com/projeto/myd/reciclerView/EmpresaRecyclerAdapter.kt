package com.projeto.myd.reciclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.projeto.myd.R
import com.projeto.myd.com.projeto.myd.model.Empresa
import kotlinx.android.synthetic.main.layout_empresas_list_item.view.*

class EmpresaRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var items : List<Empresa> = ArrayList()

    fun submitList(empresaList : List<Empresa>){
        items = empresaList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return EmpresaViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_empresas_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is EmpresaViewHolder ->{
                holder.bind(items.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class EmpresaViewHolder constructor(
        itemView : View
    ): RecyclerView.ViewHolder(itemView){
        val empresaImg: ImageView = itemView.empresa_image
        val empresaTitle: TextView = itemView.empresa_title
        val empresaCnpj: TextView = itemView.empresa_cnpj
        val empresaId: TextView = itemView.empresa_id

        fun bind(empresa: Empresa){
            empresaTitle.setText(empresa.razaoSocial)
            empresaCnpj.setText(empresa.cnpj)
            empresaId.setText(empresa.id.toString())

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context).applyDefaultRequestOptions(requestOptions)
                .load(empresa.urlDaLogo)
                .into(empresaImg)
        }
    }

}