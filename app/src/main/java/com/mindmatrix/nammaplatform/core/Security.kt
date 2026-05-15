package com.mindmatrix.nammaplatform.core

import java.security.MessageDigest
import java.security.SecureRandom
import java.util.Base64

object PasswordHasher {
    fun newSalt(): String {
        val bytes = ByteArray(16)
        SecureRandom().nextBytes(bytes)
        return Base64.getEncoder().encodeToString(bytes)
    }

    fun hash(password: String, salt: String): String {
        val digest = MessageDigest.getInstance("SHA-256")
        val bytes = digest.digest((salt + password).toByteArray())
        return Base64.getEncoder().encodeToString(bytes)
    }

    fun verify(password: String, salt: String, expectedHash: String): Boolean {
        return hash(password, salt) == expectedHash
    }
}
