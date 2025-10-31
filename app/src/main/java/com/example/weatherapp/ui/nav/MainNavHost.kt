package com.example.weatherapp.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.weatherapp.ui.pages.HomePage
import com.example.weatherapp.ui.pages.ListPage
import com.example.weatherapp.ui.pages.MapPage
import com.example.weatherapp.viewmodel.MainViewModel

@Composable
fun MainNavHost(navController: NavHostController, viewModel : MainViewModel) {
    NavHost(navController, startDestination = Route.Home) {
        composable<Route.Home> { HomePage(viewModel = viewModel) }
        composable<Route.List> { ListPage(viewModel = viewModel) }
        composable<Route.Map> { MapPage(viewModel = viewModel) }
    }
}