package com.mindmatrix.nammaplatform.presentation.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mindmatrix.nammaplatform.presentation.auth.AuthViewModel
import com.mindmatrix.nammaplatform.presentation.home.ForgotPasswordScreen
import com.mindmatrix.nammaplatform.presentation.home.HomeScreen
import com.mindmatrix.nammaplatform.presentation.home.LoginScreen
import com.mindmatrix.nammaplatform.presentation.home.OnboardingScreen
import com.mindmatrix.nammaplatform.presentation.home.RailwayViewModel
import com.mindmatrix.nammaplatform.presentation.home.SettingsScreen
import com.mindmatrix.nammaplatform.presentation.home.SignupScreen
import com.mindmatrix.nammaplatform.presentation.home.SplashScreen
import com.mindmatrix.nammaplatform.presentation.home.StationSelectorScreen
import com.mindmatrix.nammaplatform.presentation.home.TrainListScreen

object Routes {
    const val Splash = "splash"
    const val Onboarding = "onboarding"
    const val Login = "login"
    const val Signup = "signup"
    const val Forgot = "forgot"
    const val Home = "home"
    const val Stations = "stations"
    const val Trains = "trains/{stationCode}"
    const val Settings = "settings"
}

@Composable
fun NammaPlatformNavHost() {
    val navController = rememberNavController()
    val authViewModel: AuthViewModel = hiltViewModel()
    val railwayViewModel: RailwayViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = Routes.Splash,
        enterTransition = { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left, tween(350)) },
        exitTransition = { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left, tween(350)) },
        popEnterTransition = { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Right, tween(350)) },
        popExitTransition = { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right, tween(350)) }
    ) {
        composable(Routes.Splash) {
            SplashScreen(authViewModel) { route ->
                navController.navigate(route) { popUpTo(Routes.Splash) { inclusive = true } }
            }
        }
        composable(Routes.Onboarding) {
            OnboardingScreen(
                onDone = {
                    authViewModel.completeOnboarding()
                    navController.navigate(Routes.Login) { popUpTo(Routes.Onboarding) { inclusive = true } }
                }
            )
        }
        composable(Routes.Login) {
            LoginScreen(
                viewModel = authViewModel,
                onSignup = { navController.navigate(Routes.Signup) },
                onForgot = { navController.navigate(Routes.Forgot) },
                onSuccess = { navController.navigate(Routes.Home) { popUpTo(Routes.Login) { inclusive = true } } }
            )
        }
        composable(Routes.Signup) {
            SignupScreen(authViewModel) {
                navController.navigate(Routes.Home) { popUpTo(Routes.Login) { inclusive = true } }
            }
        }
        composable(Routes.Forgot) {
            ForgotPasswordScreen(authViewModel) { navController.popBackStack() }
        }
        composable(Routes.Home) {
            HomeScreen(
                authViewModel = authViewModel,
                railwayViewModel = railwayViewModel,
                onStations = { navController.navigate(Routes.Stations) },
                onSettings = { navController.navigate(Routes.Settings) },
                onOpenTrains = { code -> navController.navigate("trains/$code") }
            )
        }
        composable(Routes.Stations) {
            StationSelectorScreen(
                viewModel = railwayViewModel,
                onBack = { navController.popBackStack() },
                onSelected = { code ->
                    railwayViewModel.selectStation(code)
                    navController.navigate("trains/$code")
                }
            )
        }
        composable(
            Routes.Trains,
            arguments = listOf(navArgument("stationCode") { type = NavType.StringType })
        ) { entry ->
            val code = entry.arguments?.getString("stationCode").orEmpty()
            TrainListScreen(
                stationCode = code,
                viewModel = railwayViewModel,
                onBack = { navController.popBackStack() },
                onSettings = { navController.navigate(Routes.Settings) }
            )
        }
        composable(Routes.Settings) {
            SettingsScreen(
                authViewModel = authViewModel,
                onBack = { navController.popBackStack() },
                onLoggedOut = { navController.navigate(Routes.Login) { popUpTo(0) } }
            )
        }
    }
}
