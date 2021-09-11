package com.example.freemovies.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.freemovies.model.MovieData
import com.example.freemovies.repository.MainRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainViewModel(private val repo: MainRepo) : ViewModel() {

    private val _userList = MutableStateFlow<List<MovieData>?>(emptyList())

    val userList: StateFlow<List<MovieData>?> = _userList

    fun refresh(){
        getMovieFromServer()
    }



    fun getMovieFromServer() {
        viewModelScope.launch {
            _userList.value = repo.getMovie()
        }
    }
}