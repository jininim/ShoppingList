package com.mvvm.basket.ui.list.db

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ProductRepository(private val productDao: ProductDao) {

    val allProduct: LiveData<List<Product>> = productDao.getProduct()
    val totalPrice : LiveData<Int> = productDao.getSumOfPrice()
    val count : LiveData<Int> = productDao.getCount()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.

    suspend fun insert(product: Product) {
        productDao.insert(product)
    }
    suspend fun updateProduct(product: Product){
        productDao.updateProduct(product)
    }

    suspend fun deleteProduct(product: Product){
        productDao.deleteProduct(product)
    }
    suspend fun deleteAllProduct(){
        productDao.deleteAll()
    }
}