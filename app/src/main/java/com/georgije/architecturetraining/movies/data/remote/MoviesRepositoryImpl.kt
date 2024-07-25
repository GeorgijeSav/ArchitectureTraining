package com.georgije.architecturetraining.movies.data.remote

import com.georgije.architecturetraining.movies.domain.MoviesRepository
import javax.inject.Inject
import retrofit2.Retrofit

class MoviesRepositoryImpl
@Inject
constructor(
	private val moviesTransformer: MoviesTransformer,
	retrofit: Retrofit,
) : MoviesRepository {
	private val api = retrofit.create(MoviesApi::class.java)

	override suspend fun fetchAllMovies() = moviesTransformer.transform(api.getMovies())
}
