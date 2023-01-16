package com.example.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmorty.ui.screens.CharactersScreen
import com.example.rickandmorty.ui.theme.RickAndMortyTheme
import com.example.rickandmorty.ui.viewmodels.CharactersViewModel
import com.example.rickandmorty.ui.viewmodels.CharactersViewModelFactory

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: CharactersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            CharactersViewModelFactory()
        )[CharactersViewModel::class.java]

        setContent {
            val characters = viewModel.getCharacters().collectAsState(emptyList())

            RickAndMortyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   CharactersScreen(rickAndMortyCharacterNames = characters.value)
                }
            }
        }
    }
}