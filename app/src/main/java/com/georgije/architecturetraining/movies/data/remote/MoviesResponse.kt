package com.georgije.architecturetraining.movies.data.remote

import com.fasterxml.jackson.annotation.JsonProperty

data class MoviesResponse(
	@JsonProperty("page")
	val page: Int,
	@JsonProperty("results")
	val results: List<MoviesResponseData>,
	@JsonProperty("total_pages")
	val totalPages: Int,
	@JsonProperty("total_results")
	val totalResults: Int,
)
