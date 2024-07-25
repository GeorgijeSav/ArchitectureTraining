package com.georgije.architecturetraining.moviedetail.data.remote

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigInteger
import java.util.Date

@JsonIgnoreProperties(ignoreUnknown = true)
data class MovieDetailResponse(
	@JsonProperty("id")
	val id: Int,
	@JsonProperty("genres")
	val genres: List<MovieGenreResponse>,
	@JsonProperty("adult")
	val adult: Boolean,
	@JsonProperty("backdrop_path")
	val backdropPath: String,
	@JsonProperty("belongs_to_collection")
	val belongsToCollection: Any,
	@JsonProperty("budget")
	val budget: BigInteger,
	@JsonProperty("homepage")
	val homepage: String,
	@JsonProperty("imdb_id")
	val imdbId: String,
	@JsonProperty("original_language")
	val originalLanguage: String,
	@JsonProperty("original_title")
	val originalTitle: String,
	@JsonProperty("overview")
	val overview: String,
	@JsonProperty("popularity")
	val popularity: Double,
	@JsonProperty("origin_country")
	val originalCountry: List<OriginalCountryResponse>,
	@JsonProperty("poster_path")
	val posterPath: String,
	@JsonProperty("production_companies")
	val productionCompanies: List<ProductionCompanyResponse>,
	@JsonProperty("production_countries")
	val productionCountries: List<ProductionCountryResponse>,
	@JsonProperty("release_date")
	val releaseDate: Date,
	@JsonProperty("revenue")
	val revenue: BigInteger,
	@JsonProperty("runtime")
	val runtime: Int,
	@JsonProperty("spoken_languages")
	val spokenLanguages: List<SpokenLanguageResponse>,
	@JsonProperty("status")
	val status: String,
	@JsonProperty("tagline")
	val tagline: String,
	@JsonProperty("title")
	val title: String,
	@JsonProperty("video")
	val video: Boolean,
	@JsonProperty("vote_average")
	val voteAverage: Double,
	@JsonProperty("vote_count")
	val voteCount: BigInteger,
)

data class MovieGenreResponse(
	@JsonProperty("id")
	val id: Int,
	@JsonProperty("name")
	val name: String,
)

data class OriginalCountryResponse(
	val name: String,
)

data class ProductionCompanyResponse(
	@JsonProperty("id")
	val id: Int,
	@JsonProperty("logo_path")
	val logoPath: String,
	@JsonProperty("name")
	val name: String,
	@JsonProperty("origin_country")
	val originCountry: String,
)

data class ProductionCountryResponse(
	@JsonProperty("iso_3166_1")
	val iso31661: String,
	@JsonProperty("name")
	val name: String,
)

data class SpokenLanguageResponse(
	@JsonProperty("english_name")
	val englishName: String,
	@JsonProperty("iso_639_1")
	val iso6391: String,
	@JsonProperty("name")
	val name: String,
)
