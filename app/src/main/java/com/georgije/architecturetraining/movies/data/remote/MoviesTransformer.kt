package com.georgije.architecturetraining.movies.data.remote

import com.georgije.architecturetraining.movies.domain.entity.MovieData
import javax.inject.Inject

class MoviesTransformer @Inject constructor() {
	fun transform(movies: List<MoviesResponse>): List<MovieData> {
		val movieDataList = mutableListOf<MovieData>()
		movies.forEach { movie ->
			movie.results.forEach { movieResult ->
				movieDataList.add(
					MovieData(
						id = movieResult.id,
						title = movieResult.title,
						posterPath = movieResult.posterPath,
						overview = movieResult.overview,
						releaseDate = movieResult.releaseDate,
						originalLanguage = movieResult.originalLanguage,
						adult = movieResult.adult,
						backdropPath = movieResult.backdropPath,
					),
				)
			}
		}
		return movieDataList
	}
}
