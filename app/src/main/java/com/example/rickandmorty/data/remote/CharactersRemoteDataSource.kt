package com.example.rickandmorty.data.remote

import com.example.rickandmorty.models.Characters
import com.example.rickandmorty.models.RickAndMortyCharacter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.http.GET
import retrofit2.http.Path

class CharactersRemoteDataSource(
    private val charactersApi: CharactersApi
) {
    fun getCharacters(): Flow<Characters> = flow {
        val characters = charactersApi.fetchCharacters()
        emit(characters)
    }

    fun character(id: Int): Flow<RickAndMortyCharacter> = flow {
        val character = charactersApi.fetchCharacter(id)
        emit(character)
    }
}

interface CharactersApi {
    @GET("character")
    suspend fun fetchCharacters(): Characters

    @GET("character/{id}")
    suspend fun fetchCharacter(@Path("id") id: Int): RickAndMortyCharacter
}