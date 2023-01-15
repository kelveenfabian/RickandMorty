package com.example.rickandmorty.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmorty.data.remote.CharactersRemoteDataSource
import com.example.rickandmorty.data.repositories.CharactersRepository
import com.example.rickandmorty.network.RetrofitBuilder

class CharactersViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(CharactersRepository::class.java).newInstance(
            CharactersRepository(
                CharactersRemoteDataSource(RetrofitBuilder.charactersApi)
            )
        )
    }
}