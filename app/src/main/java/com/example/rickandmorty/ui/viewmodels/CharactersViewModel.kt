package com.example.rickandmorty.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.repositories.CharactersRepository

class CharactersViewModel(
    private val repository: CharactersRepository
) : ViewModel() {

    val characters = repository.characters
}