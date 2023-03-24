package com.mvvm.basket.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.mvvm.basket.R
import com.mvvm.basket.databinding.FragmentTabOneBinding
import com.mvvm.basket.databinding.FragmentTabThreeBinding


class TabThreeFragment : Fragment() {
    private var _binding: FragmentTabThreeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_tab_three,container,false)







        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
