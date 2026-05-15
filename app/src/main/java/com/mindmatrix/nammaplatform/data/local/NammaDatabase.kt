package com.mindmatrix.nammaplatform.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [UserEntity::class, FavoriteStationEntity::class, RecentStationEntity::class],
    version = 1,
    exportSchema = false
)
abstract class NammaDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun stationDao(): StationDao
}
