package com.example.rickandmorty.network

import com.example.rickandmorty.data.remote.CharactersApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CharactersApiProvider {
    private const val BASE_URL = "https://rickandmortyapi.com/api/"

    val charactersApi: CharactersApi by lazy { createCharactersApi() }
    private fun createCharactersApi() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CharactersApi::class.java)
}
