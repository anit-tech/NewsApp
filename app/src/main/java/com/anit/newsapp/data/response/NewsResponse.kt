package com.anit.newsapp.data.response

import com.anit.newsapp.data.model.News

data class NewsResponse(
    val available: Int,
    val news: List<News>,
    val number: Int,
    val offset: Int
)