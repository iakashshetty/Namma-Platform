package com.mindmatrix.nammaplatform.presentation.navigation;

import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.runtime.Composable;
import androidx.navigation.NavType;
import com.mindmatrix.nammaplatform.presentation.auth.AuthViewModel;
import com.mindmatrix.nammaplatform.presentation.home.RailwayViewModel;

@kotlin.Metadata(mv = {2, 1, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/mindmatrix/nammaplatform/presentation/navigation/Routes;", "", "<init>", "()V", "Splash", "", "Onboarding", "Login", "Signup", "Forgot", "Home", "Stations", "Trains", "Settings", "app_debug"})
public final class Routes {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String Splash = "splash";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String Onboarding = "onboarding";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String Login = "login";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String Signup = "signup";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String Forgot = "forgot";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String Home = "home";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String Stations = "stations";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String Trains = "trains/{stationCode}";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String Settings = "settings";
    @org.jetbrains.annotations.NotNull()
    public static final com.mindmatrix.nammaplatform.presentation.navigation.Routes INSTANCE = null;
    
    private Routes() {
        super();
    }
}