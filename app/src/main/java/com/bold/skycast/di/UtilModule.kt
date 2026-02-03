package com.bold.skycast.di

import com.bold.skycast.presentation.util.DateFormatter
import com.bold.skycast.presentation.util.DateFormatterData
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UtilModule {

    @Binds
    abstract fun bindDateFormatter(
        impl: DateFormatterData
    ): DateFormatter
}