package com.example.rickandmorty.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.rickandmorty.models.RickAndMortyCharacter

@Composable
fun CharactersScreen(rickAndMortyCharacterNames: List<RickAndMortyCharacter>) {
    LazyColumn(
    modifier = Modifier
        .fillMaxSize()
    ) {
        items(rickAndMortyCharacterNames) { item: RickAndMortyCharacter ->
            CharacterCard(character = item)
            Spacer(modifier = Modifier.padding(4.dp))
        }
    }
}

@Composable
fun CharacterCard(character: RickAndMortyCharacter) {
    Card (modifier = Modifier.fillMaxWidth()) {
        Row {
            AsyncImage(model = character.image, contentDescription = character.name)
            Spacer(modifier = Modifier.padding(4.dp))
            Column {
                Text(character.name)
                Text(character.species)
                Text(character.status)
            }
        }
    }
}