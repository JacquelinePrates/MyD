package com.projeto.myd.fragments


import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.projeto.myd.R
import kotlinx.android.synthetic.main.fragment_fragment_grupos.*

class fragmentGrupos : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_grupos, container, false)
    }
}
