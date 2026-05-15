package com.mindmatrix.nammaplatform.data.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {2, 1, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u0003H\'J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/mindmatrix/nammaplatform/data/local/StationDao;", "", "observeFavorites", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/mindmatrix/nammaplatform/data/local/FavoriteStationEntity;", "observeRecent", "Lcom/mindmatrix/nammaplatform/data/local/RecentStationEntity;", "addFavorite", "", "favorite", "(Lcom/mindmatrix/nammaplatform/data/local/FavoriteStationEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeFavorite", "stationCode", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addRecent", "recent", "(Lcom/mindmatrix/nammaplatform/data/local/RecentStationEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface StationDao {
    
    @androidx.room.Query(value = "SELECT * FROM favorite_stations ORDER BY addedAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.mindmatrix.nammaplatform.data.local.FavoriteStationEntity>> observeFavorites();
    
    @androidx.room.Query(value = "SELECT * FROM recent_stations ORDER BY viewedAt DESC LIMIT 8")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.mindmatrix.nammaplatform.data.local.RecentStationEntity>> observeRecent();
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addFavorite(@org.jetbrains.annotations.NotNull()
    com.mindmatrix.nammaplatform.data.local.FavoriteStationEntity favorite, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM favorite_stations WHERE stationCode = :stationCode")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object removeFavorite(@org.jetbrains.annotations.NotNull()
    java.lang.String stationCode, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addRecent(@org.jetbrains.annotations.NotNull()
    com.mindmatrix.nammaplatform.data.local.RecentStationEntity recent, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}