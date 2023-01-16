package com.example.rickandmorty.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.repositories.CharactersRepository
import com.example.rickandmorty.models.RickAndMortyCharacter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CharactersViewModel(
    private val repository: CharactersRepository
) : ViewModel() {
    fun getCharacterNames(): Flow<List<String>> =
        repository.getCharacters().map { result -> result.rickAndMortyCharacters.map { it.name } }

    fun getCharacters(): Flow<List<RickAndMortyCharacter>> =
        repository.getCharacters().map { result -> result.rickAndMortyCharacters }
}
