package com.antony.learncomposereenu.data.source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SummaryDao {

    @Query("Select * from OrderDetails")
    suspend fun getAllOrders() : List<OrderDetails>

    @Insert
    suspend fun addOrder(orderDetails: OrderDetails): Long?
}