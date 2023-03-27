package com.mvvm.basket.ui.list.db

import android.app.Application
import android.content.Context
import android.view.View
import androidx.lifecycle.*
import com.mvvm.basket.ui.list.DialogAdd
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ProductViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData : LiveData<List<Product>>
    private val repository :ProductRepository

    init {
        val productDao = ProductRoomDatabase.getDatabase(application).productDao()
        repository = ProductRepository(productDao)
        readAllData = repository.allProduct
    }

    fun addProduct(product: Product){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(product)
        }
    }

    fun deleteProduct(product: Product){
        viewModelScope.launch(Dispatchers.IO) {
            if(product.check){
                repository.deleteProduct(product)
            }


        }
    }

    fun deleteAllProduct(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllProduct()

        }
    }
    fun updateProduct(product: Product){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateProduct(product)
        }
    }


    fun dialogShowAdd(context: Context) {
        val dialog = DialogAdd(context)
        dialog.showDia()
        dialog.setOnClickListener(object : DialogAdd.ButtonClickListener{
            override fun onClicked(product: Product) {
                addProduct(product)
            }
        })

    }


}