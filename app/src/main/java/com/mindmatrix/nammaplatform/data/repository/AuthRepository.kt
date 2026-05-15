package com.mindmatrix.nammaplatform.data.repository

import com.mindmatrix.nammaplatform.core.PasswordHasher
import com.mindmatrix.nammaplatform.data.local.UserDao
import com.mindmatrix.nammaplatform.data.local.UserEntity
import com.mindmatrix.nammaplatform.data.session.SessionManager
import com.mindmatrix.nammaplatform.domain.model.UserProfile
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

sealed interface AuthResult {
    data object Success : AuthResult
    data class Error(val message: String) : AuthResult
}

@Singleton
class AuthRepository @Inject constructor(
    private val userDao: UserDao,
    private val sessionManager: SessionManager
) {
    val session = sessionManager.session

    fun observeProfile(userId: Long): Flow<UserProfile?> {
        return userDao.observeById(userId).map { it?.toProfile() }
    }

    suspend fun createAccount(name: String, email: String, phone: String, password: String, confirm: String): AuthResult {
        if (name.isBlank() || email.isBlank() || phone.length < 10) return AuthResult.Error("Please enter valid details.")
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) return AuthResult.Error("Enter a valid email.")
        if (password.length < 6) return AuthResult.Error("Password must be at least 6 characters.")
        if (password != confirm) return AuthResult.Error("Passwords do not match.")
        if (userDao.findByEmail(email.lowercase()) != null) return AuthResult.Error("Email already exists.")

        val salt = PasswordHasher.newSalt()
        val id = userDao.insert(
            UserEntity(
                name = name.trim(),
                email = email.trim().lowercase(),
                phone = phone.trim(),
                passwordHash = PasswordHasher.hash(password, salt),
                passwordSalt = salt
            )
        )
        sessionManager.login(id, rememberMe = true)
        return AuthResult.Success
    }

    suspend fun login(email: String, password: String, rememberMe: Boolean): AuthResult {
        val user = userDao.findByEmail(email.trim().lowercase()) ?: return AuthResult.Error("Account not found.")
        return if (PasswordHasher.verify(password, user.passwordSalt, user.passwordHash)) {
            sessionManager.login(user.id, rememberMe)
            AuthResult.Success
        } else {
            AuthResult.Error("Incorrect password.")
        }
    }

    suspend fun resetPassword(email: String, otp: String, password: String): AuthResult {
        val user = userDao.findByEmail(email.trim().lowercase()) ?: return AuthResult.Error("Account not found.")
        if (otp != "123456") return AuthResult.Error("Use simulated OTP 123456.")
        if (password.length < 6) return AuthResult.Error("Password must be at least 6 characters.")
        val salt = PasswordHasher.newSalt()
        userDao.updatePassword(user.email, PasswordHasher.hash(password, salt), salt)
        return AuthResult.Success
    }

    suspend fun updateProfile(userId: Long, name: String, phone: String, photoUri: String?) {
        userDao.updateProfile(userId, name, phone, photoUri)
    }

    suspend fun completeOnboarding() = sessionManager.completeOnboarding()
    suspend fun logout() = sessionManager.logout()
}

private fun UserEntity.toProfile() = UserProfile(id, name, email, phone, photoUri)
