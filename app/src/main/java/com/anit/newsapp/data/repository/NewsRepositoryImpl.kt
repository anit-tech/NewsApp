package com.anit.newsapp.data.repository

import com.anit.newsapp.data.response.NewsResponse
import com.anit.newsapp.data.web.NewsApi
import com.anit.newsapp.domain.repository.NewsRepository
import retrofit2.Response
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(val api: NewsApi) : NewsRepository {

    override suspend fun getNews(
        language: String,
        text: String?,
        country: String?
    ): Response<NewsResponse> {
         return api.getNews(country,language,text)
    }
}