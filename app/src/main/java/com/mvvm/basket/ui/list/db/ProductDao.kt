package com.mvvm.basket.ui.list.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*

@Dao
interface ProductDao {
    @Query("SELECT * FROM product_table ORDER BY name ASC")
    fun getProduct(): LiveData<List<Product>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(product: Product)

    @Update
    fun updateProduct(product: Product)
    //선택한 항목 삭제
    @Delete
    fun deleteProduct(product: Product)

    //전체 삭제
    @Query("DELETE FROM product_table")
    fun deleteAll()
}