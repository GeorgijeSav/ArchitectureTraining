package com.georgije.architecturetraining.movies.domain.usecase

import com.georgije.architecturetraining.movies.data.remote.MoviesRepositoryImpl
import javax.inject.Inject

class FetchMoviesUseCase @Inject constructor(
	private val repository: MoviesRepositoryImpl,
) {
	suspend fun fetchMovies() = repository.fetchAllMovies()
}
