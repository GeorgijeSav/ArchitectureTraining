package com.georgije.architecturetraining.moviedetail.data.remote

import java.math.BigInteger
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface MovieDetailApi {
	@GET("movie/{movie_id}")
	@Headers(
		"Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjNDVmOWY4Yjg2NjI1ODQyMzc2N2FjNWRmNTVhNDFjMCIsIm5iZiI6MTcyMTczMjk2OS4wODcxMTEsInN1YiI6IjY2OWY3MGE3ZjMxM2ZmMjJiMzdkNGRiNiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.N_ZpATJop_n4HvdCvY9dVpwUbcw64W-hCx1x2guROsU",
	)
	suspend fun getMovieDetail(@Path("movie_id") movieId: BigInteger): MovieDetailResponse
}
