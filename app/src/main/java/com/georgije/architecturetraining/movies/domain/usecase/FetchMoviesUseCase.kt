package com.georgije.architecturetraining.movies.domain.usecase

import com.georgije.architecturetraining.movies.domain.MoviesRepository
import javax.inject.Inject

class FetchMoviesUseCase @Inject constructor(
	private val repository: MoviesRepository,
) {
	suspend fun fetchMovies() = repository.fetchAllMovies()
}
