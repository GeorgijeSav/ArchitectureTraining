package com.georgije.architecturetraining.di

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class RetrofitNetworkModule {
	@Provides
	@Singleton
	fun provideEndpointWithRetrofitClient(): Retrofit {
		return Retrofit
			.Builder()
			.baseUrl("https://api.themoviedb.org/3/")
			.addConverterFactory(JacksonConverterFactory.create(ObjectMapper().enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)))
			.build()
	}
}
