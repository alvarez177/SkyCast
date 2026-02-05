package com.bold.skycast.di


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.Locale

@Module
@InstallIn(SingletonComponent::class)
object LocaleModule {

    @Provides
    fun provideLocale(): Locale {
        return Locale("en", "EN")
    }
}