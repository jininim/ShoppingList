package com.mvvm.basket.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.mvvm.basket.R
import com.mvvm.basket.databinding.FragmentTabOneBinding
import com.mvvm.basket.ui.list.db.Product



class TabOneFragment : Fragment() {
    private var _binding: FragmentTabOneBinding? = null
    private val binding get() = _binding!!



    private val product = mutableListOf<Product>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tab_one, container, false)

        val adapter = RecyclerAdapter(product)
        binding.Recycle.adapter = adapter
        binding.Recycle.layoutManager = LinearLayoutManager(requireContext())

        //리스트 추가
        product.apply {
            add(Product("아이스크림", "ㅎㅎㅎㅎㅎ", 1500))
            add(Product("마우스", "asdasd", 20000))
            add(Product("핸드폰", "asdasd", 500000))
            add(Product("키보드", "asdas", 45000))
            add(Product("스피커", "asddassad", 20000))
        }


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}