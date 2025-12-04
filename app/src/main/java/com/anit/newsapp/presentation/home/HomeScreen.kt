package com.anit.newsapp.presentation.home

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
fun HomeScreen(){
    val viewModel: HomeViewModel = hiltViewModel()
}