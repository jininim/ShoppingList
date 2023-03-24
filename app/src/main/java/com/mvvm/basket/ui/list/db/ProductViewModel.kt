package com.mvvm.basket.ui.list.db

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductViewModel(application: Application) : AndroidViewModel(application) {

    private val readAllData : LiveData<List<Product>>
    private val repository :ProductRepository

    init {
        val productDao = ProductRoomDatabase.getDatabase(application).productDao()
        repository = ProductRepository(productDao)
        readAllData = repository.allproduct
    }

    fun addProduct(product: Product){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(product)
        }
    }

}