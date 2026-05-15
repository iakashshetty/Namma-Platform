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

@kotlin.Metadata(mv = {2, 1, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0005J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\u0006\u0010\b\u001a\u00020\tH\u00a6@\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\tH\u00a6@\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u000fH&J\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u000fH&J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u00a6@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\tH\u00a6@\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u0017"}, d2 = {"Lcom/mindmatrix/nammaplatform/data/repository/RailwayRepository;", "", "stations", "", "Lcom/mindmatrix/nammaplatform/domain/model/Station;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trainsForStation", "Lcom/mindmatrix/nammaplatform/domain/model/Train;", "stationCode", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "layout", "Lcom/mindmatrix/nammaplatform/domain/model/CoachLayout;", "layoutId", "favorites", "Lkotlinx/coroutines/flow/Flow;", "recent", "toggleFavorite", "", "isFavorite", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markRecent", "app_debug"})
public abstract interface RailwayRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object stations(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.mindmatrix.nammaplatform.domain.model.Station>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object trainsForStation(@org.jetbrains.annotations.NotNull()
    java.lang.String stationCode, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.mindmatrix.nammaplatform.domain.model.Train>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object layout(@org.jetbrains.annotations.NotNull()
    java.lang.String layoutId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.mindmatrix.nammaplatform.domain.model.CoachLayout> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.mindmatrix.nammaplatform.domain.model.Station>> favorites();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.mindmatrix.nammaplatform.domain.model.Station>> recent();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object toggleFavorite(@org.jetbrains.annotations.NotNull()
    java.lang.String stationCode, boolean isFavorite, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object markRecent(@org.jetbrains.annotations.NotNull()
    java.lang.String stationCode, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}