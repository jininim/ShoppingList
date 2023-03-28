package com.mvvm.basket.ui.list


import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.mvvm.basket.databinding.DialogAddBinding
import com.mvvm.basket.ui.list.db.Product
import com.mvvm.basket.ui.list.db.ProductViewModel


class DialogAdd(
    private val context: Context,
) {
    private val dialog = Dialog(context)
    private val binding : DialogAddBinding = DialogAddBinding.inflate(dialog.layoutInflater)

    fun showDia(){
        dialog.setContentView(binding.root)
        // 뒤로가기 버튼 및 화면 밖 터치시 다이어로그 꺼짐
        dialog.setCancelable(true)
        dialog.setCanceledOnTouchOutside(true)
        // background 투명하게 만듦
        // (중요) Dialog 내부적으로 뒤에 흰 사각형 배경이 존재하므로, 배경을 투명하게 만들지 않으면
        // corner radius 적용이 보이지 않는다.
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        binding.btnAdd.setOnClickListener {
            insertDataToDatabase()
            dialog.dismiss()
        }
        binding.btnCancle.setOnClickListener {
            dialog.dismiss()
        }


        dialog.show()
    }


    interface ButtonClickListener{
        fun onClicked(product: Product)
    }
    private lateinit var onClickListener: ButtonClickListener

    fun setOnClickListener(listener: ButtonClickListener){
        onClickListener = listener
    }
    private fun insertDataToDatabase(){
        val name = binding.ettName.text.toString()
        val store =binding.ettStore.text.toString()
        var price : Int = 0
        //edit텍스트가 비어있지 않을경우에만 price값을 변경
        if (binding.ettPrice.text?.isNotEmpty() == true){
            price = binding.ettPrice.text.toString().toInt()
        }
        val check = false
        val product = Product(name,store,price,check)
        onClickListener.onClicked(product)
    }

}

