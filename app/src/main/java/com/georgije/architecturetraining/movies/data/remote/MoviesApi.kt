package com.georgije.architecturetraining.movies.data.remote

import retrofit2.http.GET
import retrofit2.http.Headers

interface MoviesApi {
	@GET(
		"discover/movie?language=en-US&page=1&sort_by=popularity.desc",
	)
	@Headers(
		"Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjNDVmOWY4Yjg2NjI1ODQyMzc2N2FjNWRmNTVhNDFjMCIsIm5iZiI6MTcyMTczMjk2OS4wODcxMTEsInN1YiI6IjY2OWY3MGE3ZjMxM2ZmMjJiMzdkNGRiNiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.N_ZpATJop_n4HvdCvY9dVpwUbcw64W-hCx1x2guROsU",
	)
	suspend fun getMovies(): List<MoviesResponse>
}
