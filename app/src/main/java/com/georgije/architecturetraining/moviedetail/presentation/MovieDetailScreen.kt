package com.georgije.architecturetraining.moviedetail.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.math.BigInteger

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailScreen(movieId: BigInteger, viewModel: MovieDetailScreenViewModel) {
	val movieDetail = viewModel.movieDetail.observeAsState()
	val isLoading = remember {
		mutableStateOf(true)
	}
	LaunchedEffect(key1 = true) {
		viewModel.fetchMovieDetail(movieId)
		isLoading.value = false
	}
	Column(modifier = Modifier.fillMaxSize()) {
		TopAppBar(title = { Text(text = "Movie Detail") })
		Spacer(modifier = Modifier.size(16.dp))
		if (isLoading.value) {
			Text(text = "Loading Data")
		} else {
			LazyColumn(modifier = Modifier.fillMaxWidth().padding(12.dp)) {
				item {
					Card(modifier = Modifier.fillMaxWidth().padding(all = 12.dp)) {
						Text(text = "Title: ${movieDetail.value?.title}")
						Text(text = "Genre: ${movieDetail.value?.genre}")
						Text(text = "Original Language: ${movieDetail.value?.originalLanguage}")
						Text(text = "Overview: ${movieDetail.value?.overview}")
						Text(text = "Release Date: ${movieDetail.value?.releaseDate}")
						Text(text = "Original Title: ${movieDetail.value?.originalTitle}")
						Text(text = "Production Company: ${movieDetail.value?.productionCompany}")
						Text(text = "Spoken Language: ${movieDetail.value?.spokenLanguageResponse}")
					}
				}
			}
		}
	}
}
