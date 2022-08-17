package com.example.nyc.schools.di

import android.app.Application
import androidx.room.Room
import com.example.nyc.schools.data.local.SchoolDatabase
import com.example.nyc.schools.data.remote.dto.SchoolApi
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSchoolApi(): SchoolApi {
        return Retrofit.Builder()
            .baseUrl(SchoolApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }).build())
            .build().create(SchoolApi::class.java)
    }

    @Provides
    @Singleton
    fun provideSchoolDatabase(app: Application): SchoolDatabase {
        return Room.databaseBuilder(
            app,
            SchoolDatabase::class.java,
            "schooldb.db"
        ).build()
    }
}