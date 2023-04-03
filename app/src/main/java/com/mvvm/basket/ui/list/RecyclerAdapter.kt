package com.mvvm.basket.ui.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mvvm.basket.R
import com.mvvm.basket.ui.list.db.Product
import java.text.DecimalFormat


class RecyclerAdapter(val onClickUpdate: (product: Product) -> Unit) :
    RecyclerView.Adapter<ViewHolder>() {

    private val ITEM_VIEW_TYPE_HEADER = 0
    private val ITEM_VIEW_TYPE_ITEM = 1

    private var itemList = emptyList<Product>()

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            ITEM_VIEW_TYPE_HEADER
        } else {
            ITEM_VIEW_TYPE_ITEM
        }
    }


    // (1) 아이템 레이아웃과 결합
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if(viewType == ITEM_VIEW_TYPE_HEADER){
            val headerView = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_header, parent, false)
            HeaderViewHolder(headerView)
        }else{
            val itemView =
                LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
            ItemViewHolder(itemView)
        }

    }



    // (2) 리스트 내 아이템 개수
    override fun getItemCount(): Int {
        return itemList.size + 1
    }

    // (3) View 내용 입력
    @SuppressLint("SetTextI18n", "NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when(holder){
            is HeaderViewHolder ->{

            }
            is ItemViewHolder ->{
                val current = itemList[position-1]
                holder.name.text = current.name
                holder.place.text = current.period
                holder.price.text = DecimalFormat("###,###").format(current.price).toString() + "원"

                holder.checkBox.isChecked = current.check

                //체크박스 클릭시
                holder.checkBox.setOnClickListener {
                    if (!current.check) {
                        current.check = true
                        onClickUpdate.invoke(current)
                    } else {
                        current.check = false
                        onClickUpdate.invoke(current)
                    }
                }
                //아이템 클릭시
                holder.rowLayout.setOnClickListener {
                    if (!current.check) {
                        current.check = true
                        onClickUpdate.invoke(current)
                    } else {
                        current.check = false
                        onClickUpdate.invoke(current)
                    }
                }
        }


        }




    }

    // (4) 레이아웃 내 View 연결
    inner class ItemViewHolder(itemView: View) : ViewHolder(itemView) {

        val name: TextView = itemView.findViewById(R.id.ProductName)
        val place: TextView = itemView.findViewById(R.id.ProductPlace)
        val price: TextView = itemView.findViewById(R.id.ProductPrice)
        val checkBox: CheckBox = itemView.findViewById(R.id.checkBox)
        val rowLayout: LinearLayout = itemView.findViewById(R.id.rowLayout)
    }
    inner class HeaderViewHolder(itemView: View) : ViewHolder(itemView) {



    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(product: List<Product>) {
        this.itemList = product
        notifyDataSetChanged()
    }

}



