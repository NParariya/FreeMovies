package com.example.freemovies.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.freemovies.model.MovieData
import com.example.freemovies.model.Movies
import com.example.freemovies.repository.FavmovieRepoImpl
import com.example.freemovies.repository.MainRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainViewModel(private val repo: MainRepo) : ViewModel() {

/**changed*/
    /*private val _userList = MutableStateFlow<List<MovieData>?>(emptyList())
    val userList: StateFlow<List<MovieData>?> = _userList

  fun refresh(){
      getMovieFromServer()
  }



    fun getMovieFromServer() {
        viewModelScope.launch {
            _userList.value = repo.getMovie()
        }
    }
*/


    private val _userList : MutableLiveData<MovieData> = MutableLiveData()
    val userList : LiveData<MovieData> = _userList

    init {
        viewModelScope.launch {
            _userList.value = repo.getMovie()
        }
    }


}