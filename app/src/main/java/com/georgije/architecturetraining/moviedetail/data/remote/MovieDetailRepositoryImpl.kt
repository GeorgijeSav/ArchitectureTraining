package com.georgije.architecturetraining.moviedetail.data.remote

import java.math.BigInteger
import javax.inject.Inject
import retrofit2.Retrofit

class MovieDetailRepositoryImpl @Inject constructor(private val movieDetailTransformer: MovieDetailTransformer, retrofit: Retrofit) {
	private val api = retrofit.create(MovieDetailApi::class.java)

	suspend fun fetchMovieDetail(movieId: BigInteger) = movieDetailTransformer.transform(api.getMovieDetail(movieId))
}
