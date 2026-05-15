package com.mindmatrix.nammaplatform.data.local

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "users", indices = [Index(value = ["email"], unique = true)])
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val email: String,
    val phone: String,
    val passwordHash: String,
    val passwordSalt: String,
    val photoUri: String? = null
)

@Entity(tableName = "favorite_stations")
data class FavoriteStationEntity(
    @PrimaryKey val stationCode: String,
    val addedAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "recent_stations")
data class RecentStationEntity(
    @PrimaryKey val stationCode: String,
    val viewedAt: Long = System.currentTimeMillis()
)
