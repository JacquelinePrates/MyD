package com.projeto.myd.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager

import com.projeto.myd.R
import com.projeto.myd.homeActivity
import com.projeto.myd.reciclerView.EmpresaRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_fragment_empresas.*

class fragmentEmpresas : Fragment() {

    companion object{
        fun newInstance(): fragmentEmpresas{
            val fragmentEmpresas = fragmentEmpresas()
            val args = Bundle()
            fragmentEmpresas.arguments = args
            return fragmentEmpresas

        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_empresas, container, false)
    }

}