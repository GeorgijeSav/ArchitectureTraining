package com.georgije.architecturetraining.movies.domain.entity

import java.math.BigInteger
import java.util.Date

data class MovieData(
	val id: BigInteger,
	val adult: Boolean,
	val backdropPath: String,
	val originalLanguage: String,
	val overview: String,
	val posterPath: String,
	val releaseDate: Date,
	val title: String,
)
