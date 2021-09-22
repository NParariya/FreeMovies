package com.example.freemovies.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.freemovies.repository.FavmovieRepoImpl
import com.example.freemovies.repository.FavouriteRepo

class FavViewModelFactory (private val repo : FavouriteRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavViewModel::class.java)) {


            return FavViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}