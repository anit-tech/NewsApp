package com.anit.newsapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anit.newsapp.data.model.News
import com.anit.newsapp.data.response.NewsResponse
import com.anit.newsapp.domain.usecase.GetNewsUseCase
import com.anit.newsapp.presentation.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val getNewsUseCase: GetNewsUseCase): ViewModel(){
    val _state = MutableStateFlow<State<NewsResponse>>(State.Loading)
    init{
        viewModelScope.launch {
            val result = getNews()
            result.forEach {
                println("News,${it.title}-----${it.authors}")
            }
        }
    }
    suspend fun getNews(): List<News>{
        return getNewsUseCase.invoke("en",null,null).news
    }
}