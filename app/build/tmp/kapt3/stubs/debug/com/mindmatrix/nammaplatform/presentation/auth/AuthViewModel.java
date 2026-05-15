package com.mindmatrix.nammaplatform.presentation.auth;

import androidx.lifecycle.ViewModel;
import com.mindmatrix.nammaplatform.data.repository.AuthRepository;
import com.mindmatrix.nammaplatform.data.repository.AuthResult;
import com.mindmatrix.nammaplatform.data.session.SessionState;
import com.mindmatrix.nammaplatform.domain.model.UserProfile;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;
import kotlinx.coroutines.flow.StateFlow;

@kotlin.Metadata(mv = {2, 1, 0}, k = 1, xi = 48, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J.\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0018J\u001e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fJ\u001e\u0010 \u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018J(\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\b\u0010%\u001a\u0004\u0018\u00010\u0018J\u0006\u0010&\u001a\u00020\'J\u0006\u0010(\u001a\u00020\'J+\u0010)\u001a\u00020\u00162\u001c\u0010*\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,\u0012\u0006\u0012\u0004\u0018\u00010.0+H\u0002\u00a2\u0006\u0002\u0010/R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u00060"}, d2 = {"Lcom/mindmatrix/nammaplatform/presentation/auth/AuthViewModel;", "Landroidx/lifecycle/ViewModel;", "authRepository", "Lcom/mindmatrix/nammaplatform/data/repository/AuthRepository;", "<init>", "(Lcom/mindmatrix/nammaplatform/data/repository/AuthRepository;)V", "session", "Lkotlinx/coroutines/flow/Flow;", "Lcom/mindmatrix/nammaplatform/data/session/SessionState;", "getSession", "()Lkotlinx/coroutines/flow/Flow;", "profile", "Lcom/mindmatrix/nammaplatform/domain/model/UserProfile;", "getProfile", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/mindmatrix/nammaplatform/presentation/auth/AuthUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "signup", "", "name", "", "email", "phone", "password", "confirm", "login", "remember", "", "reset", "otp", "updateProfile", "userId", "", "photoUri", "completeOnboarding", "Lkotlinx/coroutines/Job;", "logout", "launchAuth", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lcom/mindmatrix/nammaplatform/data/repository/AuthResult;", "", "(Lkotlin/jvm/functions/Function1;)V", "app_debug"})
@kotlin.OptIn(markerClass = {kotlinx.coroutines.ExperimentalCoroutinesApi.class})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class AuthViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.mindmatrix.nammaplatform.data.repository.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.mindmatrix.nammaplatform.data.session.SessionState> session = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.mindmatrix.nammaplatform.domain.model.UserProfile> profile = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.mindmatrix.nammaplatform.presentation.auth.AuthUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.mindmatrix.nammaplatform.presentation.auth.AuthUiState> uiState = null;
    
    @javax.inject.Inject()
    public AuthViewModel(@org.jetbrains.annotations.NotNull()
    com.mindmatrix.nammaplatform.data.repository.AuthRepository authRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.mindmatrix.nammaplatform.data.session.SessionState> getSession() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.mindmatrix.nammaplatform.domain.model.UserProfile> getProfile() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.mindmatrix.nammaplatform.presentation.auth.AuthUiState> getUiState() {
        return null;
    }
    
    public final void signup(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String phone, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    java.lang.String confirm) {
    }
    
    public final void login(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password, boolean remember) {
    }
    
    public final void reset(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String otp, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
    }
    
    public final void updateProfile(long userId, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String phone, @org.jetbrains.annotations.Nullable()
    java.lang.String photoUri) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job completeOnboarding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job logout() {
        return null;
    }
    
    private final void launchAuth(kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super com.mindmatrix.nammaplatform.data.repository.AuthResult>, ? extends java.lang.Object> block) {
    }
}