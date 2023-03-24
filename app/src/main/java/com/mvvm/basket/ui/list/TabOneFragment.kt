package com.mvvm.basket.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.mvvm.basket.R
import com.mvvm.basket.databinding.FragmentTabOneBinding



class TabOneFragment : Fragment() {
    private var _binding: FragmentTabOneBinding? = null
    private val binding get() = _binding!!


    private val product = mutableListOf<ProductModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_tab_one,container,false)


       binding.Recycle.adapter = RecyclerAdapter(product)

        product.apply {
            add(ProductModel("ㅎㅎㅎㅎ","ㅎㅎㅎㅎㅎ",300))
            add(ProductModel("asdasd","asdasd",300))
            add(ProductModel("asdas","asdasd",300))
            add(ProductModel("asdas","asdas",300))
            add(ProductModel("asdasdas","asddassad",300))
        }


        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}