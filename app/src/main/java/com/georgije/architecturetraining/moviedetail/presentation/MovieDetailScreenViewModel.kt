package com.georgije.architecturetraining.moviedetail.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.georgije.architecturetraining.moviedetail.domain.entity.MovieDetailData
import com.georgije.architecturetraining.moviedetail.domain.uscase.FetchMovieDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import java.math.BigInteger
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class MovieDetailScreenViewModel @Inject constructor(
	private val fetchMovieDetailUseCase: FetchMovieDetailUseCase,
) : ViewModel() {
	private val _movieDetail = MutableLiveData<MovieDetailData>()
	val movieDetail = _movieDetail
	fun fetchMovieDetail(movieId: BigInteger) {
		viewModelScope.launch {
			_movieDetail.value = fetchMovieDetailUseCase.fetchMovieDetail(movieId)
		}
	}
}
