package com.mvvm.basket.ui.list.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*

@Dao
interface ProductDao {
    @Query("SELECT * FROM product_table ORDER BY name ASC")
    fun getProduct(): LiveData<List<Product>>

    //price컬럼이 Null이 아닐경우 SUM(price)를 반환하고 아닌경우 0을 반환
    @Query("SELECT COALESCE(SUM(price), 0) FROM product_table WHERE price IS NOT NULL")
    fun getSumOfPrice() : LiveData<Int>

    @Query("SELECT COUNT(*) FROM product_table")
    fun getCount() : LiveData<Int>

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