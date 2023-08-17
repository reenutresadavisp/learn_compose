package com.antony.learncomposereenu.data.repository

import com.antony.learncomposereenu.data.source.OrderDetails
import kotlinx.coroutines.flow.Flow

interface SummaryRepository {
    fun addToOrderList(qty: Int, flavour : String): Flow<Boolean>
    fun getAllOrders(): Flow<List<OrderDetails>>
}