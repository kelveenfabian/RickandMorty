package com.example.rickandmorty.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun CharactersScreen(characterNames: List<String>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Blue)
    ) {
        items(characterNames) { characterName ->
            Text(text = characterName)
        }
    }
}