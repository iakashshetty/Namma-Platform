package com.mindmatrix.nammaplatform.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mindmatrix.nammaplatform.data.repository.AuthRepository
import com.mindmatrix.nammaplatform.data.repository.AuthResult
import com.mindmatrix.nammaplatform.data.session.SessionState
import com.mindmatrix.nammaplatform.domain.model.UserProfile
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

data class AuthUiState(
    val loading: Boolean = false,
    val error: String? = null,
    val success: Boolean = false
)

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {
    val session = authRepository.session
    val profile = session.flatMapLatest { state ->
        state.userId?.let { authRepository.observeProfile(it) } ?: flowOf<UserProfile?>(null)
    }

    private val _uiState = MutableStateFlow(AuthUiState())
    val uiState: StateFlow<AuthUiState> = _uiState.asStateFlow()

    fun signup(name: String, email: String, phone: String, password: String, confirm: String) = launchAuth {
        authRepository.createAccount(name, email, phone, password, confirm)
    }

    fun login(email: String, password: String, remember: Boolean) = launchAuth {
        authRepository.login(email, password, remember)
    }

    fun reset(email: String, otp: String, password: String) = launchAuth {
        authRepository.resetPassword(email, otp, password)
    }

    fun updateProfile(userId: Long, name: String, phone: String, photoUri: String?) {
        viewModelScope.launch { authRepository.updateProfile(userId, name, phone, photoUri) }
    }

    fun completeOnboarding() = viewModelScope.launch { authRepository.completeOnboarding() }
    fun logout() = viewModelScope.launch { authRepository.logout() }

    private fun launchAuth(block: suspend () -> AuthResult) {
        viewModelScope.launch {
            _uiState.value = AuthUiState(loading = true)
            when (val result = block()) {
                AuthResult.Success -> _uiState.value = AuthUiState(success = true)
                is AuthResult.Error -> _uiState.value = AuthUiState(error = result.message)
            }
        }
    }
}
