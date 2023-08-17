package com.antony.learncomposereenu.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.antony.learncomposereenu.MainActivity
import com.antony.learncomposereenu.data.source.OrderDetails
import com.antony.learncomposereenu.ui.viewmodels.OrderViewModel


@Preview
@Composable
fun loadViewAllOrderScreen() {
    val viewModel: OrderViewModel = viewModel(LocalContext.current as MainActivity)
    val orders: List<OrderDetails> by viewModel.allOrderStateFlow.collectAsStateWithLifecycle()

    viewModel.getAllOrders() 
    LazyColumn {
        items(orders) { order ->
           Column(modifier = Modifier.padding(20.dp)) {
               Text(modifier = Modifier.padding(vertical=8.dp),text="Quantity : ${order.qty} cupcakes")
               Text(modifier = Modifier.padding(vertical=8.dp),text = "Flavour : ${order.flavour}")
               Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(color = Color.DarkGray ))

           }
        }

    }

}