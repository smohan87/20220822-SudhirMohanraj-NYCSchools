package com.example.nyc.schools.di

import com.example.nyc.schools.data.repository.SchoolRepositoryImpl
import com.example.nyc.schools.domain.repository.SchoolRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindSchoolRepository(
        schoolRepositoryImpl: SchoolRepositoryImpl
    ): SchoolRepository
}