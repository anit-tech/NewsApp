package com.anit.newsapp.presentation

sealed class State <out T>{
    object Loading : State<Nothing>()
    class Error(error: String): State<Nothing>()
    class Success<T>(data: T): State<T>()
}