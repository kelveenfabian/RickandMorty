package com.example.rickandmorty.data.remote

import com.example.rickandmorty.models.Character
import com.example.rickandmorty.models.Characters
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.http.GET
import retrofit2.http.Path

class CharactersRemoteDataSource(
    private val charactersApi: CharactersApi,
    private val refreshIntervalMs: Long = 5000
) {
    val characters: Flow<Characters> = flow {
        while(true) {
            val characters = charactersApi.fetchCharacters()
            emit(characters)
            delay(refreshIntervalMs)
        }
    }

    fun character(id: Int): Flow<Character> = flow {
        while(true) {
            val character = charactersApi.fetchCharacter(id)
            emit(character)
            delay(refreshIntervalMs)
        }
    }
}

interface CharactersApi {
    @GET("character")
    suspend fun fetchCharacters(): Characters

    @GET("character/{id}")
    suspend fun fetchCharacter(@Path("id") id: Int): Character
}