package com.antony.learncomposereenu.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antony.learncomposereenu.data.repository.SummaryRepository
import com.antony.learncomposereenu.data.source.OrderDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(val repo: SummaryRepository) : ViewModel() {
    var selectedQty: Int = 3
    var selectedFlavour: String = "Vanilla"
    private var orderCount: Int = 0

    private var _orderCountStateFlow: MutableStateFlow<Int> = MutableStateFlow(0)
    val orderCountStateFlow: StateFlow<Int> = _orderCountStateFlow

    private var _allOrdersStateFlow: MutableStateFlow<List<OrderDetails>> = MutableStateFlow(mutableListOf())
    val allOrderStateFlow: StateFlow<List<OrderDetails>> = _allOrdersStateFlow
    fun setQuantity(qty: Int) {
        selectedQty = qty
    }

    fun setFlavour(flavour: String) {
        selectedFlavour = flavour
    }

    fun submitOrder() {
        viewModelScope.launch {
            repo.addToOrderList(selectedQty, selectedFlavour).collect {
                if (it) {
                    orderCount += 1
                    _orderCountStateFlow.value = orderCount
                }
            }
        }

    }

    fun getAllOrders() {
        viewModelScope.launch {
            repo.getAllOrders().collect {
               _allOrdersStateFlow.value = it
            }
        }
    }
}