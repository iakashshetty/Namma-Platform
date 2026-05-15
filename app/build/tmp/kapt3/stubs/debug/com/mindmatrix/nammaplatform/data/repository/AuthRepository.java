package com.mindmatrix.nammaplatform.data.repository;

import com.mindmatrix.nammaplatform.core.PasswordHasher;
import com.mindmatrix.nammaplatform.data.local.UserDao;
import com.mindmatrix.nammaplatform.data.local.UserEntity;
import com.mindmatrix.nammaplatform.data.session.SessionManager;
import com.mindmatrix.nammaplatform.domain.model.UserProfile;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlinx.coroutines.flow.Flow;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {2, 1, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\t2\u0006\u0010\u000f\u001a\u00020\u0010J6\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014H\u0086@\u00a2\u0006\u0002\u0010\u0019J&\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0086@\u00a2\u0006\u0002\u0010\u001dJ&\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0086@\u00a2\u0006\u0002\u0010 J0\u0010!\u001a\u00020\"2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\b\u0010#\u001a\u0004\u0018\u00010\u0014H\u0086@\u00a2\u0006\u0002\u0010$J\u000e\u0010%\u001a\u00020\"H\u0086@\u00a2\u0006\u0002\u0010&J\u000e\u0010\'\u001a\u00020\"H\u0086@\u00a2\u0006\u0002\u0010&R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006("}, d2 = {"Lcom/mindmatrix/nammaplatform/data/repository/AuthRepository;", "", "userDao", "Lcom/mindmatrix/nammaplatform/data/local/UserDao;", "sessionManager", "Lcom/mindmatrix/nammaplatform/data/session/SessionManager;", "<init>", "(Lcom/mindmatrix/nammaplatform/data/local/UserDao;Lcom/mindmatrix/nammaplatform/data/session/SessionManager;)V", "session", "Lkotlinx/coroutines/flow/Flow;", "Lcom/mindmatrix/nammaplatform/data/session/SessionState;", "getSession", "()Lkotlinx/coroutines/flow/Flow;", "observeProfile", "Lcom/mindmatrix/nammaplatform/domain/model/UserProfile;", "userId", "", "createAccount", "Lcom/mindmatrix/nammaplatform/data/repository/AuthResult;", "name", "", "email", "phone", "password", "confirm", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "rememberMe", "", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetPassword", "otp", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateProfile", "", "photoUri", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "completeOnboarding", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "app_debug"})
public final class AuthRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.mindmatrix.nammaplatform.data.local.UserDao userDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.mindmatrix.nammaplatform.data.session.SessionManager sessionManager = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.mindmatrix.nammaplatform.data.session.SessionState> session = null;
    
    @javax.inject.Inject()
    public AuthRepository(@org.jetbrains.annotations.NotNull()
    com.mindmatrix.nammaplatform.data.local.UserDao userDao, @org.jetbrains.annotations.NotNull()
    com.mindmatrix.nammaplatform.data.session.SessionManager sessionManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.mindmatrix.nammaplatform.data.session.SessionState> getSession() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.mindmatrix.nammaplatform.domain.model.UserProfile> observeProfile(long userId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object createAccount(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String phone, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    java.lang.String confirm, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.mindmatrix.nammaplatform.data.repository.AuthResult> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object login(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password, boolean rememberMe, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.mindmatrix.nammaplatform.data.repository.AuthResult> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object resetPassword(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String otp, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.mindmatrix.nammaplatform.data.repository.AuthResult> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateProfile(long userId, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String phone, @org.jetbrains.annotations.Nullable()
    java.lang.String photoUri, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object completeOnboarding(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object logout(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}