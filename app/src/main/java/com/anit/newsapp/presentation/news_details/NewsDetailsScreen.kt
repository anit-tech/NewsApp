package com.anit.newsapp.presentation.news_details


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.anit.newsapp.data.model.News

@Composable
fun NewsDetailsScreen(navController: NavController) {
    val viewModel: NewsDetailsViewModel = hiltViewModel()
}

@Composable
fun NewsDetails(news: News) {
    Box(modifier = Modifier.fillMaxSize()) {
        AsyncImage(
            model = news.image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            contentScale = ContentScale.FillWidth
        )
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (backBtn, topSpace, summary, newContent) = createRefs()
            Spacer(
                modifier = Modifier
                    .height(350.dp)
                    .constrainAs(topSpace) {
                        top.linkTo(parent.top)
                    })
            Image(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = null,
                modifier = Modifier.height(24.dp).width(24.dp).constrainAs(backBtn){
                    top.linkTo(parent.top, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                }
            )
        }
    }
}