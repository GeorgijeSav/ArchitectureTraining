package com.georgije.architecturetraining

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.georgije.architecturetraining.moviedetail.presentation.MovieDetailScreen
import com.georgije.architecturetraining.moviedetail.presentation.MovieDetailScreenViewModel
import com.georgije.architecturetraining.movies.presentation.MoviesScreen
import com.georgije.architecturetraining.movies.presentation.MoviesScreenViewModel
import com.georgije.architecturetraining.ui.theme.ArchitectureTrainingTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	private val moviesScreenViewModel: MoviesScreenViewModel by viewModels()
	private val movieDetailScreenViewModel: MovieDetailScreenViewModel by viewModels()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			ArchitectureTrainingTheme {
				val navController = rememberNavController()
				NavHost(navController = navController, startDestination = "movies") {
					composable("movies") {
						MoviesScreen(navController = navController, viewModel = moviesScreenViewModel)
					}
					composable("detail/{id}") { backStackEntry ->
						backStackEntry.arguments?.getString("id")?.toBigInteger()
							?.let { MovieDetailScreen(movieId = it, viewModel = movieDetailScreenViewModel) }
					}
				}
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
	ArchitectureTrainingTheme {
	}
}
