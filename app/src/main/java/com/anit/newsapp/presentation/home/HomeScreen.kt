package com.anit.newsapp.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.anit.newsapp.data.model.News
import com.anit.newsapp.presentation.State

@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = hiltViewModel()
    val uiState = viewModel.state.collectAsState()
    Column(modifier = Modifier.fillMaxSize()) {
        when (uiState.value) {
            is State.Loading -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator()
                    Text(text = "Loading....")
                }
            }

            is State.Error -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator()
                    Text(text = "Failed!...")
                    Text(text = (uiState.value as State.Error).error)
                }
            }

            else -> {
                val data = (uiState.value as State.Success).data
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    item {
                        Text(text = "News")
                    }
                    items(data.news) { article ->
                        NewsItem(article)
                    }
                }
            }
        }
    }
}

@Composable
fun NewsItem(news: News) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(100.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Red.copy(alpha = 0.2f))
            .padding(8.dp)
    ){
        Column(modifier = Modifier.align(Alignment.BottomStart)) {
            Text(text = news.title)
            Text(text = news.publish_date)
        }
    }
}