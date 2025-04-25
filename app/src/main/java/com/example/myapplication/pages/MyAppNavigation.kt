package com.example.composetest.com.example.myapplication.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

@Composable
fun MyAppNavigation(modifier: Modifier=Modifier){
    val navController = rememberNavController()
}