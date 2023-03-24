package com.mvvm.basket.ui.list

import com.mvvm.basket.R

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter(private val itemList: MutableList<ProductModel>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    // (1) 아이템 레이아웃과 결합
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return ViewHolder(view)
    }
    // (2) 리스트 내 아이템 개수
    override fun getItemCount(): Int {
        return itemList.size
    }
    // (3) View에 내용 입력
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = itemList[position].name
        holder.place.text = itemList[position].place
        holder.price.text = itemList[position].price.toString()

    }
    // (4) 레이아웃 내 View 연결
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            val name: TextView = itemView.findViewById(R.id.ProductName)
            val place: TextView =itemView.findViewById(R.id.ProductPlace)
            val price : TextView = itemView.findViewById(R.id.ProductPrice)
    }

}



