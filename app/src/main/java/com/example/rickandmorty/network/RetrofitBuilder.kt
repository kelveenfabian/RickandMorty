package com.example.rickandmorty.network

import com.example.rickandmorty.data.remote.CharactersApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private const val BASE_URL = "https://rickandmortyapi.com/api/"

    private fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val charactersApi: CharactersApi = getRetrofit().create(CharactersApi::class.java)
}