package com.anit.newsapp.data.web

import retrofit2.Response
import retrofit2.http.GET


interface NewsApi {
    @GET("v2/top-headlines?country=us&apiKey")
    suspend fun getNews(): Response<String>
}