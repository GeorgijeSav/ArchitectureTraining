package com.georgije.architecturetraining.movies.domain

import com.georgije.architecturetraining.movies.domain.entity.MovieData

interface MoviesRepository {
	suspend fun fetchAllMovies(): List<MovieData>
}
