package com.mindmatrix.nammaplatform.presentation.home;

import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.ExperimentalMaterial3Api;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import androidx.compose.ui.text.style.TextAlign;
import com.airbnb.lottie.compose.LottieCompositionSpec;
import com.mindmatrix.nammaplatform.domain.model.Coach;
import com.mindmatrix.nammaplatform.domain.model.CoachType;
import com.mindmatrix.nammaplatform.domain.model.Station;
import com.mindmatrix.nammaplatform.domain.model.Train;
import com.mindmatrix.nammaplatform.presentation.auth.AuthViewModel;
import com.mindmatrix.nammaplatform.presentation.navigation.Routes;
import com.mindmatrix.nammaplatform.presentation.tts.NammaTtsController;

@kotlin.Metadata(mv = {2, 1, 0}, k = 2, xi = 48, d1 = {"\u0000p\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a\u0016\u0010\u0007\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007\u001a:\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007\u001a\u001e\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007\u001a\u001e\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007\u001a6\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0005\u00a2\u0006\u0002\b\u0015\u00a2\u0006\u0002\b\u0016H\u0003\u001aH\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a\u001e\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0003\u001a0\u0010 \u001a\u00020\u00012\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0003\u001a2\u0010%\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00062\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\"0\'2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0003\u001a2\u0010(\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u001a2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a4\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u001a2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007\u001a\u001a\u0010-\u001a\u00020\u00012\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010.\u001a\u00020/H\u0003\u001a\u001e\u00100\u001a\u00020\u00012\u0006\u0010#\u001a\u00020$2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0003\u001a*\u00102\u001a\u00020\u00012\f\u00103\u001a\b\u0012\u0004\u0012\u0002040\'2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u00010\u0005H\u0003\u001a$\u00106\u001a\u00020\u00012\u0006\u00107\u001a\u0002042\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u00010\u0005H\u0003\u001a,\u00108\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00032\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007\u001a3\u0010:\u001a\u00020\u00012\u0006\u0010;\u001a\u00020<2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0011\u0010=\u001a\r\u0012\u0004\u0012\u00020\u00010\t\u00a2\u0006\u0002\b\u0015H\u0003\u001a4\u0010>\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\"2\u0006\u0010?\u001a\u00020/2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0003\u001aE\u0010A\u001a\u00020\u00012\u0006\u0010B\u001a\u00020\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\u00010\u0005\u00a2\u0006\u0002\b\u0015H\u0003\u001a4\u0010D\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00062\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0010\b\u0002\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tH\u0003\u001a\u001b\u0010F\u001a\u00020\u00012\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00010\t\u00a2\u0006\u0002\b\u0015H\u0003\u00a8\u0006G"}, d2 = {"SplashScreen", "", "viewModel", "Lcom/mindmatrix/nammaplatform/presentation/auth/AuthViewModel;", "onRoute", "Lkotlin/Function1;", "", "OnboardingScreen", "onDone", "Lkotlin/Function0;", "LoginScreen", "onSignup", "onForgot", "onSuccess", "SignupScreen", "ForgotPasswordScreen", "AuthScaffold", "title", "subtitle", "content", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "HomeScreen", "authViewModel", "railwayViewModel", "Lcom/mindmatrix/nammaplatform/presentation/home/RailwayViewModel;", "onStations", "onSettings", "onOpenTrains", "HeroCard", "name", "SmartRecommendation", "station", "Lcom/mindmatrix/nammaplatform/domain/model/Station;", "train", "Lcom/mindmatrix/nammaplatform/domain/model/Train;", "StationSection", "stations", "", "StationSelectorScreen", "onBack", "onSelected", "TrainListScreen", "stationCode", "PlatformCard", "ttsReady", "", "TrainCard", "onClick", "CoachStrip", "coaches", "Lcom/mindmatrix/nammaplatform/domain/model/Coach;", "onCoach", "CoachPill", "coach", "SettingsScreen", "onLoggedOut", "SettingRow", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "trailing", "StationRow", "isFavorite", "onFavorite", "AppScaffold", "selected", "Landroidx/compose/foundation/layout/PaddingValues;", "NammaTopBar", "action", "PremiumBackground", "app_debug"})
public final class ScreensKt {
    
    @androidx.compose.runtime.Composable()
    public static final void SplashScreen(@org.jetbrains.annotations.NotNull()
    com.mindmatrix.nammaplatform.presentation.auth.AuthViewModel viewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onRoute) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void OnboardingScreen(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDone) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void LoginScreen(@org.jetbrains.annotations.NotNull()
    com.mindmatrix.nammaplatform.presentation.auth.AuthViewModel viewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSignup, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onForgot, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SignupScreen(@org.jetbrains.annotations.NotNull()
    com.mindmatrix.nammaplatform.presentation.auth.AuthViewModel viewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ForgotPasswordScreen(@org.jetbrains.annotations.NotNull()
    com.mindmatrix.nammaplatform.presentation.auth.AuthViewModel viewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDone) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void AuthScaffold(java.lang.String title, java.lang.String subtitle, androidx.compose.runtime.internal.ComposableFunction1<? super androidx.compose.foundation.layout.ColumnScope, kotlin.Unit> content) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void HomeScreen(@org.jetbrains.annotations.NotNull()
    com.mindmatrix.nammaplatform.presentation.auth.AuthViewModel authViewModel, @org.jetbrains.annotations.NotNull()
    com.mindmatrix.nammaplatform.presentation.home.RailwayViewModel railwayViewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onStations, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSettings, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onOpenTrains) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void HeroCard(java.lang.String name, kotlin.jvm.functions.Function0<kotlin.Unit> onStations) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void SmartRecommendation(com.mindmatrix.nammaplatform.domain.model.Station station, com.mindmatrix.nammaplatform.domain.model.Train train, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onOpenTrains) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void StationSection(java.lang.String title, java.util.List<com.mindmatrix.nammaplatform.domain.model.Station> stations, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onOpenTrains) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void StationSelectorScreen(@org.jetbrains.annotations.NotNull()
    com.mindmatrix.nammaplatform.presentation.home.RailwayViewModel viewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBack, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSelected) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void TrainListScreen(@org.jetbrains.annotations.NotNull()
    java.lang.String stationCode, @org.jetbrains.annotations.NotNull()
    com.mindmatrix.nammaplatform.presentation.home.RailwayViewModel viewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBack, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSettings) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void PlatformCard(com.mindmatrix.nammaplatform.domain.model.Train train, boolean ttsReady) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void TrainCard(com.mindmatrix.nammaplatform.domain.model.Train train, kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void CoachStrip(java.util.List<com.mindmatrix.nammaplatform.domain.model.Coach> coaches, kotlin.jvm.functions.Function1<? super com.mindmatrix.nammaplatform.domain.model.Coach, kotlin.Unit> onCoach) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void CoachPill(com.mindmatrix.nammaplatform.domain.model.Coach coach, kotlin.jvm.functions.Function1<? super com.mindmatrix.nammaplatform.domain.model.Coach, kotlin.Unit> onCoach) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SettingsScreen(@org.jetbrains.annotations.NotNull()
    com.mindmatrix.nammaplatform.presentation.auth.AuthViewModel authViewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBack, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onLoggedOut) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void SettingRow(androidx.compose.ui.graphics.vector.ImageVector icon, java.lang.String title, java.lang.String subtitle, androidx.compose.runtime.internal.ComposableFunction0<kotlin.Unit> trailing) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void StationRow(com.mindmatrix.nammaplatform.domain.model.Station station, boolean isFavorite, kotlin.jvm.functions.Function0<kotlin.Unit> onFavorite, kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void AppScaffold(java.lang.String selected, kotlin.jvm.functions.Function0<kotlin.Unit> onStations, kotlin.jvm.functions.Function0<kotlin.Unit> onSettings, androidx.compose.runtime.internal.ComposableFunction1<? super androidx.compose.foundation.layout.PaddingValues, kotlin.Unit> content) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    private static final void NammaTopBar(java.lang.String title, kotlin.jvm.functions.Function0<kotlin.Unit> onBack, kotlin.jvm.functions.Function0<kotlin.Unit> action) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void PremiumBackground(androidx.compose.runtime.internal.ComposableFunction0<kotlin.Unit> content) {
    }
}