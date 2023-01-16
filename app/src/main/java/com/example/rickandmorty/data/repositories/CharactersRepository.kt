package com.example.rickandmorty.data.repositories

import com.example.rickandmorty.data.remote.CharactersRemoteDataSource
import com.example.rickandmorty.models.Characters
import com.example.rickandmorty.models.RickAndMortyCharacter
import kotlinx.coroutines.flow.Flow

class CharactersRepository(
    private val charactersRemoteDataSource: CharactersRemoteDataSource
) {

    fun getCharacters(): Flow<Characters> = charactersRemoteDataSource.getCharacters()
    fun character(id: Int): Flow<RickAndMortyCharacter> = charactersRemoteDataSource.character(id)
}