package com.example.rickandmorty.data.repositories

import com.example.rickandmorty.data.remote.CharactersRemoteDataSource
import com.example.rickandmorty.models.Character
import com.example.rickandmorty.models.Characters
import kotlinx.coroutines.flow.Flow

class CharactersRepository(
    private val charactersRemoteDataSource: CharactersRemoteDataSource
) {

    val characters: Flow<Characters> = charactersRemoteDataSource.characters
    fun character(id: Int): Flow<Character> = charactersRemoteDataSource.character(id)
}