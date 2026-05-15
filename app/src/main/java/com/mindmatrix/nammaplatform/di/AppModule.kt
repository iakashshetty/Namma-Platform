package com.mindmatrix.nammaplatform.di

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.mindmatrix.nammaplatform.data.local.NammaDatabase
import com.mindmatrix.nammaplatform.data.local.StationDao
import com.mindmatrix.nammaplatform.data.local.UserDao
import com.mindmatrix.nammaplatform.data.repository.AssetRailwayRepository
import com.mindmatrix.nammaplatform.data.repository.RailwayRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindRailwayRepository(repository: AssetRailwayRepository): RailwayRepository
}

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): NammaDatabase {
        return Room.databaseBuilder(context, NammaDatabase::class.java, "namma-platform.db")
            .build()
    }

    @Provides
    fun provideUserDao(database: NammaDatabase): UserDao = database.userDao()

    @Provides
    fun provideStationDao(database: NammaDatabase): StationDao = database.stationDao()
}
