package com.georgije.architecturetraining.moviedetail.domain

import com.georgije.architecturetraining.moviedetail.domain.entity.MovieDetailData
import java.math.BigInteger

interface MovieDetailRepository {

	suspend fun fetchMovieDetail(movieId: BigInteger): MovieDetailData
}
