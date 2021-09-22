package com.example.freemovies.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.freemovies.network.RetroFitBuilder
import com.example.freemovies.repository.MainRepoImpl

class ViewModelFactory () : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepoImpl(RetroFitBuilder.apiService)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}