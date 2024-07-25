package com.georgije.architecturetraining.moviedetail.domain.entity

import java.util.Date

data class MovieDetailData(
	val id: Int,
	val genre: List<MovieDetailGenreData>,
	val title: String,
	val originalLanguage: String,
	val overview: String,
	val releaseDate: Date,
	val originalTitle: String,
	val productionCompany: List<MovieDetailProductionCompanyData>,
	val spokenLanguageResponse: List<MovieDetailSpokenLanguagesData>,

)

data class MovieDetailGenreData(
	val id: Int,
	val genre: String,
)
data class MovieDetailProductionCompanyData(
	val id: Int,
	val name: String,
	val originalCountry: String,
)

data class MovieDetailSpokenLanguagesData(
	val englishName: String,
	val iso6391: String,
	val name: String,
)
