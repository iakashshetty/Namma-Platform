package com.mindmatrix.nammaplatform.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mindmatrix.nammaplatform.data.repository.RailwayRepository
import com.mindmatrix.nammaplatform.domain.model.CoachLayout
import com.mindmatrix.nammaplatform.domain.model.Station
import com.mindmatrix.nammaplatform.domain.model.Train
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class RailwayUiState(
    val loading: Boolean = true,
    val stations: List<Station> = emptyList(),
    val selectedStation: Station? = null,
    val trains: List<Train> = emptyList(),
    val selectedLayout: CoachLayout? = null,
    val query: String = ""
)

@HiltViewModel
class RailwayViewModel @Inject constructor(
    private val railwayRepository: RailwayRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(RailwayUiState())
    val uiState: StateFlow<RailwayUiState> = _uiState.asStateFlow()

    val favorites = railwayRepository.favorites().stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())
    val recent = railwayRepository.recent().stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    init {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(stations = railwayRepository.stations(), loading = false)
        }
    }

    fun search(query: String) {
        _uiState.value = _uiState.value.copy(query = query)
    }

    fun selectStation(code: String) {
        viewModelScope.launch {
            val station = railwayRepository.stations().firstOrNull { it.code == code }
            val trains = railwayRepository.trainsForStation(code)
            railwayRepository.markRecent(code)
            _uiState.value = _uiState.value.copy(selectedStation = station, trains = trains, selectedLayout = null)
            trains.firstOrNull()?.let { selectTrain(it) }
        }
    }

    fun selectTrain(train: Train) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(selectedLayout = railwayRepository.layout(train.coachLayoutId))
        }
    }

    fun toggleFavorite(code: String, alreadyFavorite: Boolean) {
        viewModelScope.launch { railwayRepository.toggleFavorite(code, alreadyFavorite) }
    }
}
