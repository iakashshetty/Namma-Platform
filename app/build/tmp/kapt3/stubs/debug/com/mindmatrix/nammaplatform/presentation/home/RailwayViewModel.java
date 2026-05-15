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

@kotlin.Metadata(mv = {2, 1, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f\u00a8\u0006\u001f"}, d2 = {"Lcom/mindmatrix/nammaplatform/presentation/home/RailwayViewModel;", "Landroidx/lifecycle/ViewModel;", "railwayRepository", "Lcom/mindmatrix/nammaplatform/data/repository/RailwayRepository;", "<init>", "(Lcom/mindmatrix/nammaplatform/data/repository/RailwayRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/mindmatrix/nammaplatform/presentation/home/RailwayUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "favorites", "", "Lcom/mindmatrix/nammaplatform/domain/model/Station;", "getFavorites", "recent", "getRecent", "search", "", "query", "", "selectStation", "code", "selectTrain", "train", "Lcom/mindmatrix/nammaplatform/domain/model/Train;", "toggleFavorite", "alreadyFavorite", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class RailwayViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.mindmatrix.nammaplatform.data.repository.RailwayRepository railwayRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.mindmatrix.nammaplatform.presentation.home.RailwayUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.mindmatrix.nammaplatform.presentation.home.RailwayUiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.mindmatrix.nammaplatform.domain.model.Station>> favorites = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.mindmatrix.nammaplatform.domain.model.Station>> recent = null;
    
    @javax.inject.Inject()
    public RailwayViewModel(@org.jetbrains.annotations.NotNull()
    com.mindmatrix.nammaplatform.data.repository.RailwayRepository railwayRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.mindmatrix.nammaplatform.presentation.home.RailwayUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.mindmatrix.nammaplatform.domain.model.Station>> getFavorites() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.mindmatrix.nammaplatform.domain.model.Station>> getRecent() {
        return null;
    }
    
    public final void search(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    public final void selectStation(@org.jetbrains.annotations.NotNull()
    java.lang.String code) {
    }
    
    public final void selectTrain(@org.jetbrains.annotations.NotNull()
    com.mindmatrix.nammaplatform.domain.model.Train train) {
    }
    
    public final void toggleFavorite(@org.jetbrains.annotations.NotNull()
    java.lang.String code, boolean alreadyFavorite) {
    }
}