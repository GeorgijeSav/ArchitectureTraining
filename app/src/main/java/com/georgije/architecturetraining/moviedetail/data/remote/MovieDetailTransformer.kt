package com.georgije.architecturetraining.moviedetail.data.remote

import com.georgije.architecturetraining.moviedetail.domain.entity.MovieDetailData
import com.georgije.architecturetraining.moviedetail.domain.entity.MovieDetailGenreData
import com.georgije.architecturetraining.moviedetail.domain.entity.MovieDetailProductionCompanyData
import com.georgije.architecturetraining.moviedetail.domain.entity.MovieDetailSpokenLanguagesData
import javax.inject.Inject

class MovieDetailTransformer @Inject constructor() {
	fun transform(movie: MovieDetailResponse): MovieDetailData {
		return MovieDetailData(
			id = movie.id,
			genre = movie.genres.map { genre ->
				MovieDetailGenreData(
					id = genre.id,
					genre = genre.name,
				)
			},
			title = movie.title,
			originalLanguage = movie.originalLanguage,
			overview = movie.overview,
			releaseDate = movie.releaseDate,
			originalTitle = movie.originalTitle,
			productionCompany = movie.productionCompanies.map { productionCompany ->
				MovieDetailProductionCompanyData(
					id = productionCompany.id,
					name = productionCompany.name,
					originalCountry = productionCompany.originCountry,
				)
			},
			spokenLanguageResponse = movie.spokenLanguages.map { spokenLanguage ->
				MovieDetailSpokenLanguagesData(
					englishName = spokenLanguage.englishName,
					iso6391 = spokenLanguage.iso6391,
					name = spokenLanguage.name,
				)
			},
		)
	}
}
