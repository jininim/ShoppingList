package com.mvvm.basket.ui.list.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class ProductRoomDatabase : RoomDatabase() {

    abstract fun productDao() : ProductDao
    companion object {
        @Volatile //다른 thread에서 접근 가능하게 만드는 것입니다.
        private var INSTANCE: ProductRoomDatabase? = null
        fun getDatabase(context: Context): ProductRoomDatabase {

            return INSTANCE ?: synchronized(this) {//synchronized는 새로운 데이터베이스를 instance시킵니다.
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductRoomDatabase::class.java,
                    "product_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

}
