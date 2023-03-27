package com.mvvm.basket.ui.list

import com.mvvm.basket.R

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.mvvm.basket.ui.list.db.Product
import com.mvvm.basket.ui.list.db.ProductViewModel


class RecyclerAdapter(val onClickUpdate: (product: Product) -> Unit) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private var itemList = emptyList<Product>()

    // (1) 아이템 레이아웃과 결합
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return ViewHolder(view)
    }

    // (2) 리스트 내 아이템 개수
    override fun getItemCount(): Int {
        return itemList.size
    }

    // (3) View에 내용 입력
    @SuppressLint("SetTextI18n", "NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = itemList[position]
        holder.name.text = current.name
        holder.place.text = current.place
        holder.price.text = current.price.toString()
        holder.checkBox.isChecked = current.check
        holder.checkBox.setOnClickListener {
            if (!current.check) {
                current.check = true
                onClickUpdate.invoke(current)
            } else {
                current.check = false
                onClickUpdate.invoke(current)
            }
        }


    }

    // (4) 레이아웃 내 View 연결
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.ProductName)
        val place: TextView = itemView.findViewById(R.id.ProductPlace)
        val price: TextView = itemView.findViewById(R.id.ProductPrice)
        val checkBox: CheckBox = itemView.findViewById(R.id.checkBox)
        val rowLayout: LinearLayout = itemView.findViewById(R.id.rowLayout)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(product: List<Product>) {
        this.itemList = product
        notifyDataSetChanged()
    }

}



