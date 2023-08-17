package com.antony.learncomposereenu.data.repository

import com.antony.learncomposereenu.data.source.AppDatabase
import com.antony.learncomposereenu.data.source.OrderDetails
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SummaryRepositoryImpl @Inject constructor(private val db: AppDatabase) : SummaryRepository {
    override fun addToOrderList(qty: Int, flavour: String): Flow<Boolean> =
        flow{
            val rowId = db.getSummaryDao().addOrder(OrderDetails(qty= qty, flavour = flavour))
            emit(rowId)
        }.map { it != null }



    override fun getAllOrders(): Flow<List<OrderDetails>> = flow{
        val result = db.getSummaryDao().getAllOrders()
        emit(result)
    }
}