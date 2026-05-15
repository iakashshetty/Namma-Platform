package com.mindmatrix.nammaplatform.data.session

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.sessionDataStore by preferencesDataStore(name = "namma_session")

data class SessionState(
    val userId: Long? = null,
    val rememberMe: Boolean = false,
    val onboardingComplete: Boolean = false
)

@Singleton
class SessionManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val userIdKey = longPreferencesKey("user_id")
    private val rememberKey = booleanPreferencesKey("remember_me")
    private val onboardingKey = booleanPreferencesKey("onboarding_complete")

    val session: Flow<SessionState> = context.sessionDataStore.data.map { prefs ->
        SessionState(
            userId = prefs[userIdKey],
            rememberMe = prefs[rememberKey] ?: false,
            onboardingComplete = prefs[onboardingKey] ?: false
        )
    }

    suspend fun login(userId: Long, rememberMe: Boolean) {
        context.sessionDataStore.edit { prefs ->
            prefs[userIdKey] = userId
            prefs[rememberKey] = rememberMe
        }
    }

    suspend fun completeOnboarding() {
        context.sessionDataStore.edit { prefs -> prefs[onboardingKey] = true }
    }

    suspend fun logout() {
        context.sessionDataStore.edit { prefs ->
            prefs.remove(userIdKey)
            prefs[rememberKey] = false
        }
    }
}
