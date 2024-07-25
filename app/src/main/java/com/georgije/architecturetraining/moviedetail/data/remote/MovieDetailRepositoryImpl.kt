package com.georgije.architecturetraining.moviedetail.data.remote

import com.georgije.architecturetraining.moviedetail.domain.MovieDetailRepository
import java.math.BigInteger
import javax.inject.Inject
import retrofit2.Retrofit

class MovieDetailRepositoryImpl @Inject constructor(private val movieDetailTransformer: MovieDetailTransformer, retrofit: Retrofit) : MovieDetailRepository {
	private val api = retrofit.create(MovieDetailApi::class.java)

	override suspend fun fetchMovieDetail(movieId: BigInteger) = movieDetailTransformer.transform(api.getMovieDetail(movieId))
}
