package com.bold.data.di

import com.bold.data.repository.ForecastDataRepository
import com.bold.data.repository.LocationDataRepository
import com.bold.domain.repository.ForecastRepository
import com.bold.domain.repository.LocationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindLocationRepository(locationRepository: LocationDataRepository): LocationRepository

    @Singleton
    @Binds
    abstract fun bindForecastRepository(locationRepository: ForecastDataRepository): ForecastRepository
}