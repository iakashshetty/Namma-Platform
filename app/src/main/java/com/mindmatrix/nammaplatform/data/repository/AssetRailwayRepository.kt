package com.mindmatrix.nammaplatform.data.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mindmatrix.nammaplatform.data.local.FavoriteStationEntity
import com.mindmatrix.nammaplatform.data.local.RecentStationEntity
import com.mindmatrix.nammaplatform.data.local.StationDao
import com.mindmatrix.nammaplatform.domain.model.CoachLayout
import com.mindmatrix.nammaplatform.domain.model.Station
import com.mindmatrix.nammaplatform.domain.model.Train
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.withContext

interface RailwayRepository {
    suspend fun stations(): List<Station>
    suspend fun trainsForStation(stationCode: String): List<Train>
    suspend fun layout(layoutId: String): CoachLayout?
    fun favorites(): Flow<List<Station>>
    fun recent(): Flow<List<Station>>
    suspend fun toggleFavorite(stationCode: String, isFavorite: Boolean)
    suspend fun markRecent(stationCode: String)
}

@Singleton
class AssetRailwayRepository @Inject constructor(
    @ApplicationContext private val context: Context,
    private val stationDao: StationDao,
    private val gson: Gson
) : RailwayRepository {
    private var stationsCache: List<Station>? = null
    private var trainsCache: List<Train>? = null
    private var layoutsCache: List<CoachLayout>? = null

    override suspend fun stations(): List<Station> = withContext(Dispatchers.IO) {
        stationsCache ?: readAsset<List<Station>>("stations.json", object : TypeToken<List<Station>>() {}.type)
            .also { stationsCache = it }
    }

    override suspend fun trainsForStation(stationCode: String): List<Train> = withContext(Dispatchers.IO) {
        val trains = trainsCache ?: readAsset<List<Train>>("trains.json", object : TypeToken<List<Train>>() {}.type)
            .also { trainsCache = it }
        trains.filter { it.stationCode == stationCode }.take(3)
    }

    override suspend fun layout(layoutId: String): CoachLayout? = withContext(Dispatchers.IO) {
        val layouts = layoutsCache ?: readAsset<List<CoachLayout>>("coach_layouts.json", object : TypeToken<List<CoachLayout>>() {}.type)
            .also { layoutsCache = it }
        layouts.firstOrNull { it.id == layoutId }
    }

    override fun favorites(): Flow<List<Station>> {
        return stationDao.observeFavorites().combine(stationsFlow()) { favorites, stations ->
            favorites.mapNotNull { favorite -> stations.firstOrNull { it.code == favorite.stationCode } }
        }
    }

    override fun recent(): Flow<List<Station>> {
        return stationDao.observeRecent().combine(stationsFlow()) { recent, stations ->
            recent.mapNotNull { item -> stations.firstOrNull { it.code == item.stationCode } }
        }
    }

    override suspend fun toggleFavorite(stationCode: String, isFavorite: Boolean) {
        if (isFavorite) stationDao.removeFavorite(stationCode) else stationDao.addFavorite(FavoriteStationEntity(stationCode))
    }

    override suspend fun markRecent(stationCode: String) {
        stationDao.addRecent(RecentStationEntity(stationCode))
    }

    private fun stationsFlow(): Flow<List<Station>> = kotlinx.coroutines.flow.flow { emit(stations()) }

    private fun <T> readAsset(fileName: String, type: java.lang.reflect.Type): T {
        val json = context.assets.open(fileName).bufferedReader().use { it.readText() }
        return gson.fromJson(json, type)
    }
}
