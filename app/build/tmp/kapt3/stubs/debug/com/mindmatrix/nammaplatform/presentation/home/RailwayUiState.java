package com.mindmatrix.nammaplatform.presentation.home;

import androidx.lifecycle.ViewModel;
import com.mindmatrix.nammaplatform.data.repository.RailwayRepository;
import com.mindmatrix.nammaplatform.domain.model.CoachLayout;
import com.mindmatrix.nammaplatform.domain.model.Station;
import com.mindmatrix.nammaplatform.domain.model.Train;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

@kotlin.Metadata(mv = {2, 1, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H\u00c6\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\t\u0010 \u001a\u00020\rH\u00c6\u0003JU\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u00c6\u0001J\u0013\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010$\u001a\u00020%H\u00d6\u0001J\t\u0010&\u001a\u00020\rH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\'"}, d2 = {"Lcom/mindmatrix/nammaplatform/presentation/home/RailwayUiState;", "", "loading", "", "stations", "", "Lcom/mindmatrix/nammaplatform/domain/model/Station;", "selectedStation", "trains", "Lcom/mindmatrix/nammaplatform/domain/model/Train;", "selectedLayout", "Lcom/mindmatrix/nammaplatform/domain/model/CoachLayout;", "query", "", "<init>", "(ZLjava/util/List;Lcom/mindmatrix/nammaplatform/domain/model/Station;Ljava/util/List;Lcom/mindmatrix/nammaplatform/domain/model/CoachLayout;Ljava/lang/String;)V", "getLoading", "()Z", "getStations", "()Ljava/util/List;", "getSelectedStation", "()Lcom/mindmatrix/nammaplatform/domain/model/Station;", "getTrains", "getSelectedLayout", "()Lcom/mindmatrix/nammaplatform/domain/model/CoachLayout;", "getQuery", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class RailwayUiState {
    private final boolean loading = false;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.mindmatrix.nammaplatform.domain.model.Station> stations = null;
    @org.jetbrains.annotations.Nullable()
    private final com.mindmatrix.nammaplatform.domain.model.Station selectedStation = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.mindmatrix.nammaplatform.domain.model.Train> trains = null;
    @org.jetbrains.annotations.Nullable()
    private final com.mindmatrix.nammaplatform.domain.model.CoachLayout selectedLayout = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String query = null;
    
    public RailwayUiState(boolean loading, @org.jetbrains.annotations.NotNull()
    java.util.List<com.mindmatrix.nammaplatform.domain.model.Station> stations, @org.jetbrains.annotations.Nullable()
    com.mindmatrix.nammaplatform.domain.model.Station selectedStation, @org.jetbrains.annotations.NotNull()
    java.util.List<com.mindmatrix.nammaplatform.domain.model.Train> trains, @org.jetbrains.annotations.Nullable()
    com.mindmatrix.nammaplatform.domain.model.CoachLayout selectedLayout, @org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        super();
    }
    
    public final boolean getLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.mindmatrix.nammaplatform.domain.model.Station> getStations() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.mindmatrix.nammaplatform.domain.model.Station getSelectedStation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.mindmatrix.nammaplatform.domain.model.Train> getTrains() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.mindmatrix.nammaplatform.domain.model.CoachLayout getSelectedLayout() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getQuery() {
        return null;
    }
    
    public RailwayUiState() {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.mindmatrix.nammaplatform.domain.model.Station> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.mindmatrix.nammaplatform.domain.model.Station component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.mindmatrix.nammaplatform.domain.model.Train> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.mindmatrix.nammaplatform.domain.model.CoachLayout component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.mindmatrix.nammaplatform.presentation.home.RailwayUiState copy(boolean loading, @org.jetbrains.annotations.NotNull()
    java.util.List<com.mindmatrix.nammaplatform.domain.model.Station> stations, @org.jetbrains.annotations.Nullable()
    com.mindmatrix.nammaplatform.domain.model.Station selectedStation, @org.jetbrains.annotations.NotNull()
    java.util.List<com.mindmatrix.nammaplatform.domain.model.Train> trains, @org.jetbrains.annotations.Nullable()
    com.mindmatrix.nammaplatform.domain.model.CoachLayout selectedLayout, @org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}