package com.mindmatrix.nammaplatform.data.repository;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mindmatrix.nammaplatform.data.local.FavoriteStationEntity;
import com.mindmatrix.nammaplatform.data.local.RecentStationEntity;
import com.mindmatrix.nammaplatform.data.local.StationDao;
import com.mindmatrix.nammaplatform.domain.model.CoachLayout;
import com.mindmatrix.nammaplatform.domain.model.Station;
import com.mindmatrix.nammaplatform.domain.model.Train;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {2, 1, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B#\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0096@\u00a2\u0006\u0002\u0010\u0012J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@\u00a2\u0006\u0002\u0010\u0016J\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0018\u001a\u00020\u0015H\u0096@\u00a2\u0006\u0002\u0010\u0016J\u0014\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u001aH\u0016J\u0014\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u001aH\u0016J\u001e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001fH\u0096@\u00a2\u0006\u0002\u0010 J\u0016\u0010!\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@\u00a2\u0006\u0002\u0010\u0016J\u0014\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u001aH\u0002J#\u0010#\u001a\u0002H$\"\u0004\b\u0000\u0010$2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\'H\u0002\u00a2\u0006\u0002\u0010(R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/mindmatrix/nammaplatform/data/repository/AssetRailwayRepository;", "Lcom/mindmatrix/nammaplatform/data/repository/RailwayRepository;", "context", "Landroid/content/Context;", "stationDao", "Lcom/mindmatrix/nammaplatform/data/local/StationDao;", "gson", "Lcom/google/gson/Gson;", "<init>", "(Landroid/content/Context;Lcom/mindmatrix/nammaplatform/data/local/StationDao;Lcom/google/gson/Gson;)V", "stationsCache", "", "Lcom/mindmatrix/nammaplatform/domain/model/Station;", "trainsCache", "Lcom/mindmatrix/nammaplatform/domain/model/Train;", "layoutsCache", "Lcom/mindmatrix/nammaplatform/domain/model/CoachLayout;", "stations", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trainsForStation", "stationCode", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "layout", "layoutId", "favorites", "Lkotlinx/coroutines/flow/Flow;", "recent", "toggleFavorite", "", "isFavorite", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markRecent", "stationsFlow", "readAsset", "T", "fileName", "type", "Ljava/lang/reflect/Type;", "(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "app_debug"})
public final class AssetRailwayRepository implements com.mindmatrix.nammaplatform.data.repository.RailwayRepository {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.mindmatrix.nammaplatform.data.local.StationDao stationDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.mindmatrix.nammaplatform.domain.model.Station> stationsCache;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.mindmatrix.nammaplatform.domain.model.Train> trainsCache;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.mindmatrix.nammaplatform.domain.model.CoachLayout> layoutsCache;
    
    @javax.inject.Inject()
    public AssetRailwayRepository(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.mindmatrix.nammaplatform.data.local.StationDao stationDao, @org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gson) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object stations(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.mindmatrix.nammaplatform.domain.model.Station>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object trainsForStation(@org.jetbrains.annotations.NotNull()
    java.lang.String stationCode, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.mindmatrix.nammaplatform.domain.model.Train>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object layout(@org.jetbrains.annotations.NotNull()
    java.lang.String layoutId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.mindmatrix.nammaplatform.domain.model.CoachLayout> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.mindmatrix.nammaplatform.domain.model.Station>> favorites() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.mindmatrix.nammaplatform.domain.model.Station>> recent() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object toggleFavorite(@org.jetbrains.annotations.NotNull()
    java.lang.String stationCode, boolean isFavorite, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object markRecent(@org.jetbrains.annotations.NotNull()
    java.lang.String stationCode, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.mindmatrix.nammaplatform.domain.model.Station>> stationsFlow() {
        return null;
    }
    
    private final <T extends java.lang.Object>T readAsset(java.lang.String fileName, java.lang.reflect.Type type) {
        return null;
    }
}