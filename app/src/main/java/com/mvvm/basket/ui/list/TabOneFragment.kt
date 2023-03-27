package com.mvvm.basket.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mvvm.basket.R
import com.mvvm.basket.databinding.FragmentTabOneBinding
import com.mvvm.basket.ui.list.db.ProductViewModel


class TabOneFragment : Fragment() {
    private var _binding: FragmentTabOneBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tab_one, container, false)
        //뷰모델 연결
        val productViewModel =
            ViewModelProvider(this)[ProductViewModel::class.java]

        //리사이클러뷰
        val adapter = RecyclerAdapter(onClickUpdate = {
            productViewModel.updateProduct(it)
        })
        binding.Recycle.adapter = adapter
        binding.Recycle.layoutManager = LinearLayoutManager(requireContext())


        //product 값 변경 감지
        productViewModel.readAllData.observe(viewLifecycleOwner, Observer { products ->
            adapter.setData(products)

            //fabDel 버튼 클릭시 이벤트
            binding.fabDel.setOnClickListener {
                for (i in products){
                    if (i.check){
                        productViewModel.deleteProduct(i)
                    }
                }
            }


        })

        //fabAdd 버튼 클릭 시
        binding.fabAdd.setOnClickListener {
            productViewModel.dialogShowAdd(requireContext())
        }



        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}