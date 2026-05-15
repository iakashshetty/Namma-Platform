package com.mindmatrix.nammaplatform.data.session;

import android.content.Context;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlinx.coroutines.flow.Flow;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {2, 1, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0019"}, d2 = {"Lcom/mindmatrix/nammaplatform/data/session/SessionManager;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "userIdKey", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "rememberKey", "", "onboardingKey", "session", "Lkotlinx/coroutines/flow/Flow;", "Lcom/mindmatrix/nammaplatform/data/session/SessionState;", "getSession", "()Lkotlinx/coroutines/flow/Flow;", "login", "", "userId", "rememberMe", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "completeOnboarding", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "app_debug"})
public final class SessionManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.Long> userIdKey = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> rememberKey = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> onboardingKey = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.mindmatrix.nammaplatform.data.session.SessionState> session = null;
    
    @javax.inject.Inject()
    public SessionManager(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.mindmatrix.nammaplatform.data.session.SessionState> getSession() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object login(long userId, boolean rememberMe, @org.jetbrains.annotations.NotNull()
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