package com.antony.learncomposereenu.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.antony.learncomposereenu.R

@Composable
fun loadStartOrderScreen(onQuantitySelection: (Int) -> Unit) {
    Column(
        modifier =
        Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Image(
                painter = painterResource(id = R.drawable.img_cupcake),
                contentDescription = "cupcake image",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = stringResource(id = R.string.order_cupcake),
                fontSize = 24.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally))
        }
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {onQuantitySelection(3)},
                shape = CircleShape
            ) {
                Text(text = stringResource(id = R.string.three_cupcakes))
            }
            Button(
                onClick ={onQuantitySelection(6)},
                shape = CircleShape
            ) {
                Text(text = stringResource(id = R.string.six_cupcakes))
            }
            Button(
                onClick = {onQuantitySelection(12)},
                shape = CircleShape
            ) {
                Text(text = stringResource(id = R.string.twelve_cupcakes))
            }
        }
    }
}