package com.projeto.myd.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.projeto.myd.R


class fragmentDashboard : Fragment() {

    companion object{
        fun newInstance(): fragmentDashboard{
            val fragmentDashboard = fragmentDashboard()
            val args = Bundle()
            fragmentDashboard.arguments = args
            return fragmentDashboard
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_dashboard, container, false)
    }


}
