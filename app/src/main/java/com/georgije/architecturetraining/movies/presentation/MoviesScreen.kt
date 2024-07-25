package com.georgije.architecturetraining.movies.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.georgije.architecturetraining.movies.domain.entity.MovieData
import com.georgije.architecturetraining.ui.theme.ArchitectureTrainingTheme
import java.math.BigInteger
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("RememberReturnType")
@Composable
fun MoviesScreen(navController: NavHostController, viewModel: MoviesScreenViewModel) {
	val movies by viewModel.movies.observeAsState(initial = listOf())
	val isLoading = remember { mutableStateOf(true) }

	LaunchedEffect(key1 = true) {
		viewModel.fetchAllMovies()
		isLoading.value = false
	}
	Column(modifier = Modifier.fillMaxSize()) {
		TopAppBar(title = { Text(text = "Top app bar") })
		if (isLoading.value) {
			Text("Loading movies...", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
		} else if (movies.isNotEmpty()) {
			LazyColumn(
				modifier = Modifier
					.fillMaxWidth()
					.padding(all = 16.dp).padding(bottom = 16.dp),
			) {
				items(movies.size) { index ->
					MovieItem(navController, movies[index])
					Spacer(modifier = Modifier.size(16.dp))
				}
			}
		} else {
			Text("No movies found", modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center)
		}
	}
}

@Composable
fun MovieItem(navController: NavHostController, movie: MovieData) {
	Card(
		modifier = Modifier
			.fillMaxWidth()
			.clickable { navController.navigate("detail/${movie.id}") },

	) {
		Column(
			modifier = Modifier
				.fillMaxWidth()
				.padding(all = 12.dp),
		) {
			Row(modifier = Modifier.fillMaxWidth()) {
				Text(modifier = Modifier.weight(1f), text = movie.title, textAlign = TextAlign.Center)
				Text(modifier = Modifier.weight(1f), text = "Is a Adult film: ${movie.adult}", textAlign = TextAlign.Center)
			}
			Spacer(modifier = Modifier.size(16.dp))
			Row(modifier = Modifier.fillMaxWidth()) {
				Text(modifier = Modifier.fillMaxWidth(), text = "Overview:\n${movie.overview}", textAlign = TextAlign.Center)
			}
			Spacer(modifier = Modifier.size(16.dp))
			Row {
				Text(modifier = Modifier.fillMaxWidth(), text = "Release Date: ${movie.releaseDate}", textAlign = TextAlign.Center)
			}
		}
	}
}

@Preview
@Composable
private fun MovieItem_Preview() {
	ArchitectureTrainingTheme {
		MovieItem(
			navController = rememberNavController(),
			movie = MovieData(
				id = BigInteger("123456789"),
				adult = false,
				backdropPath = "/pathToBackdrop.jpg",
				originalLanguage = "en",
				overview = "This is a sample overview of the movie.",
				posterPath = "/pathToPoster.jpg",
				releaseDate = Date(),
				title = "Sample Movie Title",
			),
		)
	}
}

@Preview
@Composable
private fun MoviesScreen_Preview() {
	ArchitectureTrainingTheme {
	}
}
