package com.georgije.architecturetraining.movies.data.remote

import com.georgije.architecturetraining.movies.domain.entity.MovieData
import javax.inject.Inject
import retrofit2.Retrofit

class MoviesRepositoryImpl
@Inject
constructor(
	private val moviesTransformer: MoviesTransformer,
	retrofit: Retrofit,
) {
	private val api = retrofit.create(MoviesApi::class.java)

	suspend fun fetchAllMovies(): List<MovieData> {
		return moviesTransformer.transform(api.getMovies())
	}
}
