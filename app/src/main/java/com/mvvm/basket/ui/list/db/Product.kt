package com.mvvm.basket.ui.list.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//상품명 , 판매처 , 가격
@Entity(tableName = "product_table")
data class Product(
    @PrimaryKey @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "place") var place: String,
    @ColumnInfo(name ="price") var price: Int,
    @ColumnInfo(name ="check") var check: Boolean
)
