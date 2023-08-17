package com.antony.learncomposereenu.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.antony.learncomposereenu.MainActivity
import com.antony.learncomposereenu.ui.viewmodels.OrderViewModel

@Composable
fun loadOrderSummaryScreen(onViewAllOrderClick:() -> Unit){
    val viewModel : OrderViewModel = viewModel(LocalContext.current as MainActivity)
    val orderCount : Int by viewModel.orderCountStateFlow.collectAsStateWithLifecycle()
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(20.dp)) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = "QUANTITY", modifier = Modifier.padding(vertical = 8.dp))
            Text(text = "${viewModel.selectedQty} cupcakes", modifier = Modifier.padding(vertical = 8.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = Color.DarkGray))
            Text(text = "FLAVOR", modifier = Modifier.padding(vertical = 8.dp))
            Text("${viewModel.selectedFlavour}", modifier = Modifier.padding(vertical = 8.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = Color.DarkGray))
            Text(text = "PICKUP DATE", modifier = Modifier.padding(vertical = 8.dp))
            Text("21 July 2023", modifier = Modifier.padding(vertical = 8.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = Color.DarkGray))
            Text(
                text = "Subtotal : $20",
                fontSize = 24.sp,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(vertical = 20.dp)
            )
        }
        Column(){
            Button(modifier = Modifier.fillMaxWidth(), onClick = {viewModel.submitOrder()}){
               Text(stringResource(id = com.antony.learncomposereenu.R.string.submit))
            }
            OutlinedButton(modifier = Modifier.fillMaxWidth(), onClick = onViewAllOrderClick) {
                Text(stringResource(id = com.antony.learncomposereenu.R.string.view_orders))
                Text(orderCount.toString())
            }
        }
    }
}
