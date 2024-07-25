package com.georgije.architecturetraining.movies.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.georgije.architecturetraining.movies.domain.entity.MovieData
import com.georgije.architecturetraining.movies.domain.usecase.FetchMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@HiltViewModel
class MoviesScreenViewModel @Inject constructor(
	private val fetchMoviesUseCase: FetchMoviesUseCase,
) : ViewModel() {
	private val _movies = MutableLiveData<List<MovieData>>(emptyList())
	val movies: LiveData<List<MovieData>> = _movies
	fun fetchAllMovies() {
		viewModelScope.launch(Dispatchers.IO) {
			val result: List<MovieData> = fetchMoviesUseCase.fetchMovies()
			withContext(Dispatchers.Main) {
				_movies.value = result
			}
		}
	}
}
