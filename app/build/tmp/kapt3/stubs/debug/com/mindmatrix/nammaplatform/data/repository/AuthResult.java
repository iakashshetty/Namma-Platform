package com.mindmatrix.nammaplatform.data.repository;

import com.mindmatrix.nammaplatform.core.PasswordHasher;
import com.mindmatrix.nammaplatform.data.local.UserDao;
import com.mindmatrix.nammaplatform.data.local.UserEntity;
import com.mindmatrix.nammaplatform.data.session.SessionManager;
import com.mindmatrix.nammaplatform.domain.model.UserProfile;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {2, 1, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/mindmatrix/nammaplatform/data/repository/AuthResult;", "", "Success", "Error", "Lcom/mindmatrix/nammaplatform/data/repository/AuthResult$Error;", "Lcom/mindmatrix/nammaplatform/data/repository/AuthResult$Success;", "app_debug"})
public abstract interface AuthResult {
    
    @kotlin.Metadata(mv = {2, 1, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/mindmatrix/nammaplatform/data/repository/AuthResult$Error;", "Lcom/mindmatrix/nammaplatform/data/repository/AuthResult;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
    public static final class Error implements com.mindmatrix.nammaplatform.data.repository.AuthResult {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String message = null;
        
        public Error(@org.jetbrains.annotations.NotNull()
        java.lang.String message) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getMessage() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mindmatrix.nammaplatform.data.repository.AuthResult.Error copy(@org.jetbrains.annotations.NotNull()
        java.lang.String message) {
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
    
    @kotlin.Metadata(mv = {2, 1, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\n\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00d6\u0003J\t\u0010\b\u001a\u00020\tH\u00d6\u0001J\t\u0010\n\u001a\u00020\u000bH\u00d6\u0001\u00a8\u0006\f"}, d2 = {"Lcom/mindmatrix/nammaplatform/data/repository/AuthResult$Success;", "Lcom/mindmatrix/nammaplatform/data/repository/AuthResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class Success implements com.mindmatrix.nammaplatform.data.repository.AuthResult {
        @org.jetbrains.annotations.NotNull()
        public static final com.mindmatrix.nammaplatform.data.repository.AuthResult.Success INSTANCE = null;
        
        private Success() {
            super();
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
}