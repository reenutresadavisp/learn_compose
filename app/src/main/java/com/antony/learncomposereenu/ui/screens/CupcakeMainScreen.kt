package com.antony.learncomposereenu.ui.screens


import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.antony.learncomposereenu.MainActivity
import com.antony.learncomposereenu.data.source.AppDatabase
import com.antony.learncomposereenu.ui.viewmodels.OrderViewModel

enum class Screen(val title: String){
    START("Cupcake"),
    FLAVOUR("Choose Flavour"),
    SUMMARY("Order Summary"),
    VIEW_ORDER("Ordered Items")
}


@Composable
fun buildApp(){
    val viewModel: OrderViewModel = viewModel(LocalContext.current as MainActivity)
    val navController = rememberNavController()
    val backstackEntryState by navController.currentBackStackEntryAsState()
    var title = Screen.valueOf(backstackEntryState?.destination?.route?:Screen.START.name).title
    var isHomeScreen = navController.previousBackStackEntry == null
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(title)
                },
                navigationIcon = {
                    if (!isHomeScreen) {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(imageVector = Icons.Filled.ArrowBack, "back navigation")
                        }
                    }
                }
            )
        }
    ){
        NavHost(navController,
             Screen.START.name,
            Modifier.padding(it)
        ){
            composable(Screen.START.name){
                loadStartOrderScreen{qty ->
                    viewModel.setQuantity(qty)
                    navController.navigate(Screen.FLAVOUR.name)
                }
            }
            composable(Screen.FLAVOUR.name){
                loadChooseFlavourScreen(
                    onNextClick = {flavour ->
                        viewModel.setFlavour(flavour)
                        navController.navigate(Screen.SUMMARY.name)},
                    onCancelClick = {navController.popBackStack(Screen.START.name, false)}
                )
            }
            composable(Screen.SUMMARY.name){
                loadOrderSummaryScreen{
                    navController.navigate(Screen.VIEW_ORDER.name)}
                }
            composable(Screen.VIEW_ORDER.name){
                loadViewAllOrderScreen()
            }

        }
    }

}