package com.chapeaumoineau.pixelinvasion.di

import android.app.Application
import androidx.preference.PreferenceManager
import com.chapeaumoineau.pixelinvasion.data.repository.PreferencesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providePreferencesRepository(app: Application): PreferencesRepository =
        PreferencesRepository(sp = PreferenceManager.getDefaultSharedPreferences(app))

}