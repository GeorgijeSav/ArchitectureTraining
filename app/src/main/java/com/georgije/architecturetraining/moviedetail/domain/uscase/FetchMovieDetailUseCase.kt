package com.georgije.architecturetraining.moviedetail.domain.uscase

import com.georgije.architecturetraining.moviedetail.domain.MovieDetailRepository
import java.math.BigInteger
import javax.inject.Inject

class FetchMovieDetailUseCase @Inject constructor(
	private val movieDetailRepositoryImpl: MovieDetailRepository,
) {
	suspend fun fetchMovieDetail(movieId: BigInteger) = movieDetailRepositoryImpl.fetchMovieDetail(movieId = movieId)
}
