package com.mindmatrix.nammaplatform.core;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

@kotlin.Metadata(mv = {2, 1, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005\u00a8\u0006\f"}, d2 = {"Lcom/mindmatrix/nammaplatform/core/PasswordHasher;", "", "<init>", "()V", "newSalt", "", "hash", "password", "salt", "verify", "", "expectedHash", "app_debug"})
public final class PasswordHasher {
    @org.jetbrains.annotations.NotNull()
    public static final com.mindmatrix.nammaplatform.core.PasswordHasher INSTANCE = null;
    
    private PasswordHasher() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String newSalt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String hash(@org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    java.lang.String salt) {
        return null;
    }
    
    public final boolean verify(@org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    java.lang.String salt, @org.jetbrains.annotations.NotNull()
    java.lang.String expectedHash) {
        return false;
    }
}