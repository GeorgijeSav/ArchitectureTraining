package com.georgije.architecturetraining.movies.data.remote

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigInteger
import java.util.Date

data class MoviesResponseData(
	@JsonProperty("id")
	val id: BigInteger,
	@JsonProperty("adult")
	val adult: Boolean,
	@JsonProperty("backdrop_path")
	val backdropPath: String,
	@JsonProperty("genre_ids")
	val genreIds: List<Int>,
	@JsonProperty("original_language")
	val originalLanguage: String,
	@JsonProperty("original_title")
	val originalTitle: String,
	@JsonProperty("overview")
	val overview: String,
	@JsonProperty("popularity")
	val popularity: Double,
	@JsonProperty("poster_path")
	val posterPath: String,
	@JsonProperty("release_date")
	val releaseDate: Date,
	@JsonProperty("title")
	val title: String,
	@JsonProperty("video")
	val video: Boolean,
	@JsonProperty("vote_average")
	val voteAverage: Double,
	@JsonProperty("vote_count")
	val voteCount: Int,
)
