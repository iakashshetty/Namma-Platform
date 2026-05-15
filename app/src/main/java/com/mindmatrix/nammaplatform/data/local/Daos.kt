package com.mindmatrix.nammaplatform.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM users WHERE email = :email LIMIT 1")
    suspend fun findByEmail(email: String): UserEntity?

    @Query("SELECT * FROM users WHERE id = :id LIMIT 1")
    fun observeById(id: Long): Flow<UserEntity?>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(user: UserEntity): Long

    @Query("UPDATE users SET passwordHash = :hash, passwordSalt = :salt WHERE email = :email")
    suspend fun updatePassword(email: String, hash: String, salt: String)

    @Query("UPDATE users SET name = :name, phone = :phone, photoUri = :photoUri WHERE id = :id")
    suspend fun updateProfile(id: Long, name: String, phone: String, photoUri: String?)
}

@Dao
interface StationDao {
    @Query("SELECT * FROM favorite_stations ORDER BY addedAt DESC")
    fun observeFavorites(): Flow<List<FavoriteStationEntity>>

    @Query("SELECT * FROM recent_stations ORDER BY viewedAt DESC LIMIT 8")
    fun observeRecent(): Flow<List<RecentStationEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavorite(favorite: FavoriteStationEntity)

    @Query("DELETE FROM favorite_stations WHERE stationCode = :stationCode")
    suspend fun removeFavorite(stationCode: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addRecent(recent: RecentStationEntity)
}
