# Namma Platform

Namma Platform is a premium offline-first Android railway station guide for rural and small railway stations in Karnataka. It focuses on the SRD goals: platform guidance, next 3 trains, visual coach order, General/Ladies standing guidance, Kannada-first labels, and TextToSpeech announcements.

## Features

- Local account creation, login, remember-me session, logout, and simulated OTP password reset.
- Room-backed users, favourite stations, and recent stations.
- Offline JSON assets for Karnataka stations, train schedules, and coach layouts.
- Kannada + English UI labels for elderly and beginner users.
- Next train platform card and next train list.
- Horizontal coach visualizer with Engine, General, Ladies, Sleeper, and AC coach colors.
- Blinking General/Ladies coach highlights with “Stand Here” indicators.
- Kannada TextToSpeech Help Me action with English fallback.
- Onboarding, animated splash, bottom navigation, haptic station selection, and Material 3 UI.
- Dynamic color, dark-mode-ready theme, large readable typography, and high contrast blue/yellow palette.

## Tech Stack

- Kotlin
- Jetpack Compose
- Material 3
- Navigation Compose
- MVVM Clean Architecture
- Room Database
- Coroutines, Flow, StateFlow
- Hilt Dependency Injection
- DataStore Preferences
- Gson local asset parsing
- Android TextToSpeech
- Coil and Lottie dependencies
- Gradle Kotlin DSL
- Minimum SDK 26, target SDK 36

## Architecture

The project follows:

`UI -> ViewModel -> Repository -> DataSource`

Important packages:

- `presentation`: Compose screens, navigation, theme, ViewModels, TTS controller.
- `data.local`: Room entities, DAOs, and database.
- `data.repository`: Auth and railway repositories.
- `data.session`: DataStore session persistence.
- `domain.model`: Immutable app models.
- `assets`: `stations.json`, `trains.json`, `coach_layouts.json`, and Lottie intro animation.

## Setup

1. Open the `NammaPlatform` folder in Android Studio.
2. Let Android Studio sync Gradle.
3. Use JDK 17.
4. Build and run the `app` configuration on an emulator or Android device.

## Screenshots

Add screenshots here after running the app:

- Splash and onboarding
- Login and signup
- Home dashboard
- Station selector
- Train list and coach visualizer
- Settings

## Notes

- The app is fully offline for core functionality.
- The simulated OTP for password reset is `123456`.
- All user, favourite, recent, and session data stays on the device.

## Future Improvements

- Add real station map illustrations for each platform.
- Add voice input for station search.
- Add Compose UI tests and Room migration tests.
- Expand the local train database with more stations and timetable windows.
- Add adaptive two-pane tablet layouts for station and train browsing.
