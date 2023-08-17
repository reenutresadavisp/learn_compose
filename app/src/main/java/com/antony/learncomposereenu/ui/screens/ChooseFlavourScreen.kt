package com.antony.learncomposereenu.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.antony.learncomposereenu.MainActivity
import com.antony.learncomposereenu.R
import com.antony.learncomposereenu.ui.viewmodels.OrderViewModel


@Composable
fun  loadChooseFlavourScreen(onNextClick:(String) -> Unit, onCancelClick:() ->Unit) {
    val viewModel: OrderViewModel = viewModel(LocalContext.current as MainActivity)
    var selectedFlavour by remember { mutableStateOf(viewModel.selectedFlavour)}
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(20.dp),
        ) {
        Column(modifier = Modifier.weight(1f)) {
            val flavours = stringArrayResource(id = R.array.flavours)
            for (flavour in flavours) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = selectedFlavour == flavour,
                        onClick = { selectedFlavour = flavour })
                    Text(text = flavour, modifier = Modifier.fillMaxWidth())
                }
            }
            Box(
                modifier = Modifier
                    .background(color = Color.DarkGray)
                    .height(1.dp)
                    .fillMaxWidth()
            )
            Text(
                text = "Subtotal : $20",
                fontSize = 24.sp,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(vertical = 20.dp)
            )
        }
        Row(modifier = Modifier.fillMaxWidth()){
            OutlinedButton(onClick = onCancelClick,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ){
                Text(text = "Cancel")
            }
            Button(onClick = {onNextClick(selectedFlavour)}, modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp)) {
                Text(text = "Next")
            }
        }
    }
}