package com.mindmatrix.nammaplatform.presentation.home

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Campaign
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.DirectionsRailway
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.mindmatrix.nammaplatform.domain.model.Coach
import com.mindmatrix.nammaplatform.domain.model.CoachType
import com.mindmatrix.nammaplatform.domain.model.Station
import com.mindmatrix.nammaplatform.domain.model.Train
import com.mindmatrix.nammaplatform.presentation.auth.AuthViewModel
import com.mindmatrix.nammaplatform.presentation.navigation.Routes
import com.mindmatrix.nammaplatform.presentation.theme.AcPurple
import com.mindmatrix.nammaplatform.presentation.theme.CoachPink
import com.mindmatrix.nammaplatform.presentation.theme.PlatformYellow
import com.mindmatrix.nammaplatform.presentation.theme.RailwayBlue
import com.mindmatrix.nammaplatform.presentation.theme.SleeperBlue
import com.mindmatrix.nammaplatform.presentation.tts.NammaTtsController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(viewModel: AuthViewModel, onRoute: (String) -> Unit) {
    val session by viewModel.session.collectAsState(initial = null)
    val composition by rememberLottieComposition(LottieCompositionSpec.Asset("train_intro.json"))
    val progress by animateLottieCompositionAsState(composition, iterations = 2)
    LaunchedEffect(session) {
        val state = session ?: return@LaunchedEffect
        delay(1100)
        onRoute(
            when {
                !state.onboardingComplete -> Routes.Onboarding
                state.userId != null -> Routes.Home
                else -> Routes.Login
            }
        )
    }
    Box(
        Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color(0xFF072B56), RailwayBlue))),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            LottieAnimation(composition = composition, progress = { progress }, modifier = Modifier.size(160.dp))
            Text("Namma Platform", color = Color.White, style = MaterialTheme.typography.headlineLarge)
            Text("ನಮ್ಮ ಪ್ಲಾಟ್‌ಫಾರ್ಮ್", color = PlatformYellow, style = MaterialTheme.typography.titleLarge)
        }
    }
}

@Composable
fun OnboardingScreen(onDone: () -> Unit) {
    var page by remember { mutableStateOf(0) }
    val slides = listOf(
        "Find your platform fast" to "ಮುಂದಿನ ರೈಲು, ಪ್ಲಾಟ್‌ಫಾರ್ಮ್ ಮತ್ತು ಸಮಯ ಎಲ್ಲವೂ ಒಂದೇ ಕಡೆ.",
        "Offline station guide" to "ಇಂಟರ್ನೆಟ್ ಇಲ್ಲದಿದ್ದರೂ Karnataka station data works.",
        "Coach standing help" to "General ಮತ್ತು Ladies coach ಎಲ್ಲಿ ನಿಲ್ಲುತ್ತದೆ ಎಂದು ಸ್ಪಷ್ಟವಾಗಿ ನೋಡಿ.",
        "Kannada voice support" to "Help Me ಒತ್ತಿದರೆ Kannada announcement ಕೇಳಬಹುದು."
    )
    PremiumBackground {
        Column(Modifier.fillMaxSize().padding(24.dp), verticalArrangement = Arrangement.SpaceBetween) {
            Spacer(Modifier.height(28.dp))
            Column(horizontalAlignment = Alignment.Start) {
                Icon(Icons.Default.DirectionsRailway, null, tint = PlatformYellow, modifier = Modifier.size(72.dp))
                Spacer(Modifier.height(28.dp))
                Text(slides[page].first, style = MaterialTheme.typography.headlineLarge, color = Color.White)
                Spacer(Modifier.height(12.dp))
                Text(slides[page].second, style = MaterialTheme.typography.bodyLarge, color = Color(0xFFDDEBFF))
            }
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    slides.indices.forEach {
                        Box(
                            Modifier
                                .size(if (it == page) 14.dp else 9.dp)
                                .clip(CircleShape)
                                .background(if (it == page) PlatformYellow else Color.White.copy(alpha = 0.45f))
                        )
                    }
                }
                Button(onClick = { if (page == slides.lastIndex) onDone() else page++ }) {
                    Text(if (page == slides.lastIndex) "Start / ಪ್ರಾರಂಭಿಸಿ" else "Next")
                }
            }
        }
    }
}

@Composable
fun LoginScreen(viewModel: AuthViewModel, onSignup: () -> Unit, onForgot: () -> Unit, onSuccess: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(true) }
    val state by viewModel.uiState.collectAsState()
    LaunchedEffect(state.success) { if (state.success) onSuccess() }
    AuthScaffold(title = "Welcome back", subtitle = "ಮತ್ತೆ ಸ್ವಾಗತ") {
        OutlinedTextField(email, { email = it }, label = { Text("Email") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(password, { password = it }, label = { Text("Password") }, visualTransformation = PasswordVisualTransformation(), modifier = Modifier.fillMaxWidth())
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(rememberMe, { rememberMe = it })
            Text("Remember Me")
            Spacer(Modifier.weight(1f))
            TextButton(onClick = onForgot) { Text("Forgot?") }
        }
        state.error?.let { Text(it, color = MaterialTheme.colorScheme.error) }
        Button(onClick = { viewModel.login(email, password, rememberMe) }, modifier = Modifier.fillMaxWidth()) {
            Text("Login / ಲಾಗಿನ್")
        }
        TextButton(onClick = onSignup, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text("Create Account")
        }
    }
}

@Composable
fun SignupScreen(viewModel: AuthViewModel, onSuccess: () -> Unit) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirm by remember { mutableStateOf("") }
    val state by viewModel.uiState.collectAsState()
    LaunchedEffect(state.success) { if (state.success) onSuccess() }
    AuthScaffold(title = "Create account", subtitle = "ಸ್ಥಳೀಯ ಸುರಕ್ಷಿತ ಖಾತೆ") {
        OutlinedTextField(name, { name = it }, label = { Text("Name") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(email, { email = it }, label = { Text("Email") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(phone, { phone = it }, label = { Text("Phone Number") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(password, { password = it }, label = { Text("Password") }, visualTransformation = PasswordVisualTransformation(), modifier = Modifier.fillMaxWidth())
        OutlinedTextField(confirm, { confirm = it }, label = { Text("Confirm Password") }, visualTransformation = PasswordVisualTransformation(), modifier = Modifier.fillMaxWidth())
        state.error?.let { Text(it, color = MaterialTheme.colorScheme.error) }
        Button(onClick = { viewModel.signup(name, email, phone, password, confirm) }, modifier = Modifier.fillMaxWidth()) {
            Text("Create Account")
        }
    }
}

@Composable
fun ForgotPasswordScreen(viewModel: AuthViewModel, onDone: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var otp by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val state by viewModel.uiState.collectAsState()
    LaunchedEffect(state.success) { if (state.success) onDone() }
    AuthScaffold(title = "Reset password", subtitle = "Simulated OTP: 123456") {
        OutlinedTextField(email, { email = it }, label = { Text("Email") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(otp, { otp = it }, label = { Text("OTP") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(password, { password = it }, label = { Text("New password") }, visualTransformation = PasswordVisualTransformation(), modifier = Modifier.fillMaxWidth())
        state.error?.let { Text(it, color = MaterialTheme.colorScheme.error) }
        Button(onClick = { viewModel.reset(email, otp, password) }, modifier = Modifier.fillMaxWidth()) { Text("Reset") }
    }
}

@Composable
private fun AuthScaffold(title: String, subtitle: String, content: @Composable ColumnScope.() -> Unit) {
    PremiumBackground {
        LazyColumn(
            Modifier.fillMaxSize().padding(20.dp),
            verticalArrangement = Arrangement.Center
        ) {
            item {
                ElevatedCard(shape = RoundedCornerShape(8.dp), colors = CardDefaults.elevatedCardColors(containerColor = Color.White.copy(alpha = 0.94f))) {
                    Column(Modifier.padding(22.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
                        Icon(Icons.Default.DirectionsRailway, null, tint = RailwayBlue, modifier = Modifier.size(44.dp))
                        Text(title, style = MaterialTheme.typography.headlineLarge)
                        Text(subtitle, color = RailwayBlue, style = MaterialTheme.typography.titleLarge)
                        content()
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(
    authViewModel: AuthViewModel,
    railwayViewModel: RailwayViewModel,
    onStations: () -> Unit,
    onSettings: () -> Unit,
    onOpenTrains: (String) -> Unit
) {
    val profile by authViewModel.profile.collectAsState(initial = null)
    val state by railwayViewModel.uiState.collectAsState()
    val favorites by railwayViewModel.favorites.collectAsState()
    val recent by railwayViewModel.recent.collectAsState()
    AppScaffold(selected = "home", onStations = onStations, onSettings = onSettings) { padding ->
        LazyColumn(Modifier.padding(padding).fillMaxSize().padding(18.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            item {
                HeroCard(profile?.name ?: "Passenger", onStations)
            }
            item {
                SmartRecommendation(state.selectedStation, state.trains.firstOrNull(), onOpenTrains)
            }
            item {
                StationSection("Favourite Stations", favorites, onOpenTrains)
            }
            item {
                StationSection("Recent Stations", recent, onOpenTrains)
            }
        }
    }
}

@Composable
private fun HeroCard(name: String, onStations: () -> Unit) {
    Card(
        colors = CardDefaults.cardColors(containerColor = RailwayBlue),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text("Namaskara, $name", color = Color.White, style = MaterialTheme.typography.headlineLarge)
            Text("ನಿಮ್ಮ ರೈಲು, ಪ್ಲಾಟ್‌ಫಾರ್ಮ್ ಮತ್ತು coach guide ready.", color = Color(0xFFEAF3FF))
            Button(onClick = onStations) {
                Icon(Icons.Default.Search, null)
                Spacer(Modifier.width(8.dp))
                Text("Select Station")
            }
        }
    }
}

@Composable
private fun SmartRecommendation(station: Station?, train: Train?, onOpenTrains: (String) -> Unit) {
    ElevatedCard(shape = RoundedCornerShape(8.dp), modifier = Modifier.fillMaxWidth()) {
        Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text("AI Station Assistant", style = MaterialTheme.typography.titleLarge)
            Text(
                if (station == null) "Select a station to see the next 3 trains and standing guidance."
                else "Best next action: go to Platform ${train?.platform ?: "-"} for ${train?.name ?: "the next train"}."
            )
            station?.let {
                OutlinedButton(onClick = { onOpenTrains(it.code) }) { Text("Open guidance") }
            }
        }
    }
}

@Composable
private fun StationSection(title: String, stations: List<Station>, onOpenTrains: (String) -> Unit) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(title, style = MaterialTheme.typography.titleLarge)
        if (stations.isEmpty()) {
            Text("No stations yet", color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.55f))
        } else {
            stations.forEach { StationRow(it, false, {}, { onOpenTrains(it.code) }) }
        }
    }
}

@Composable
fun StationSelectorScreen(viewModel: RailwayViewModel, onBack: () -> Unit, onSelected: (String) -> Unit) {
    val state by viewModel.uiState.collectAsState()
    val favorites by viewModel.favorites.collectAsState()
    val favoriteCodes = favorites.map { it.code }.toSet()
    val filtered = state.stations.filter {
        it.name.contains(state.query, ignoreCase = true) ||
            it.kannadaName.contains(state.query, ignoreCase = true) ||
            it.code.contains(state.query, ignoreCase = true)
    }
    Scaffold(
        topBar = { NammaTopBar("Select Station", onBack = onBack) }
    ) { padding ->
        Column(Modifier.padding(padding).fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
            OutlinedTextField(
                value = state.query,
                onValueChange = viewModel::search,
                leadingIcon = { Icon(Icons.Default.Search, null) },
                label = { Text("Search station / ನಿಲ್ದಾಣ ಹುಡುಕಿ") },
                modifier = Modifier.fillMaxWidth()
            )
            LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                items(filtered) { station ->
                    StationRow(
                        station = station,
                        isFavorite = station.code in favoriteCodes,
                        onFavorite = { viewModel.toggleFavorite(station.code, station.code in favoriteCodes) },
                        onClick = { onSelected(station.code) }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrainListScreen(
    stationCode: String,
    viewModel: RailwayViewModel,
    onBack: () -> Unit,
    onSettings: () -> Unit
) {
    val ttsController = androidx.hilt.navigation.compose.hiltViewModel<TtsHolderViewModel>().ttsController
    val state by viewModel.uiState.collectAsState()
    val ttsReady by ttsController.isReady.collectAsState()
    val isSpeaking by ttsController.isSpeaking.collectAsState()
    var selectedCoach by remember { mutableStateOf<Coach?>(null) }
    LaunchedEffect(stationCode) {
        if (state.selectedStation?.code != stationCode) viewModel.selectStation(stationCode)
    }
    Scaffold(
        topBar = { NammaTopBar(state.selectedStation?.name ?: "Trains", onBack = onBack, action = onSettings) },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                val train = state.trains.firstOrNull()
                if (isSpeaking) ttsController.stop() else if (train != null) {
                    ttsController.speak("${train.kannadaName} - Platform ${train.platform} - General Coach - Engine-na Hinde")
                }
            }) {
                Icon(if (isSpeaking) Icons.Default.Stop else Icons.Default.Campaign, null)
            }
        }
    ) { padding ->
        LazyColumn(Modifier.padding(padding).fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
            item {
                PlatformCard(state.trains.firstOrNull(), ttsReady)
            }
            items(state.trains) { train ->
                TrainCard(train, onClick = { viewModel.selectTrain(train) })
            }
            item {
                Text("Coach Layout / ಕೋಚ್ ಕ್ರಮ", style = MaterialTheme.typography.titleLarge)
                state.selectedLayout?.let { layout ->
                    CoachStrip(layout.coaches) { selectedCoach = it }
                }
            }
        }
    }
    selectedCoach?.let {
        AlertDialog(
            onDismissRequest = { selectedCoach = null },
            confirmButton = { TextButton(onClick = { selectedCoach = null }) { Text("OK") } },
            title = { Text(it.label) },
            text = { Text("Coach ${it.code}: ${it.type.name.lowercase().replaceFirstChar { c -> c.uppercase() }}") }
        )
    }
}

@Composable
private fun PlatformCard(train: Train?, ttsReady: Boolean) {
    Card(
        colors = CardDefaults.cardColors(containerColor = PlatformYellow),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text("Next Platform", style = MaterialTheme.typography.titleLarge, color = Color(0xFF1F1B00))
            Text(train?.platform?.toString() ?: "-", style = MaterialTheme.typography.headlineLarge, color = Color(0xFF1F1B00))
            Text(train?.let { "${it.name} at ${it.departure}" } ?: "Select a station", color = Color(0xFF1F1B00))
            AssistChip(onClick = {}, label = { Text(if (ttsReady) "Kannada TTS ready" else "Preparing TTS") })
        }
    }
}

@Composable
private fun TrainCard(train: Train, onClick: () -> Unit) {
    ElevatedCard(onClick = onClick, shape = RoundedCornerShape(8.dp), modifier = Modifier.fillMaxWidth()) {
        Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.DirectionsRailway, null, tint = RailwayBlue, modifier = Modifier.size(42.dp))
            Spacer(Modifier.width(14.dp))
            Column(Modifier.weight(1f)) {
                Text("${train.number} ${train.name}", fontWeight = FontWeight.Bold)
                Text(train.kannadaName, color = RailwayBlue)
                Text("Departs ${train.departure} to ${train.destination}")
            }
            Text("PF ${train.platform}", style = MaterialTheme.typography.titleLarge, color = PlatformYellow)
        }
    }
}

@Composable
private fun CoachStrip(coaches: List<Coach>, onCoach: (Coach) -> Unit) {
    val scroll = rememberScrollState()
    Row(
        Modifier
            .fillMaxWidth()
            .horizontalScroll(scroll)
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        coaches.forEach { coach ->
            CoachPill(coach, onCoach)
        }
    }
}

@Composable
private fun CoachPill(coach: Coach, onCoach: (Coach) -> Unit) {
    val pulse = rememberInfiniteTransition(label = "coach-pulse")
    val alpha by pulse.animateFloat(
        initialValue = 0.35f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(tween(700), RepeatMode.Reverse),
        label = "border-alpha"
    )
    val important = coach.type == CoachType.GENERAL || coach.type == CoachType.LADIES
    val color = when (coach.type) {
        CoachType.ENGINE -> Color(0xFF757575)
        CoachType.GENERAL -> PlatformYellow
        CoachType.LADIES -> CoachPink
        CoachType.SLEEPER -> SleeperBlue
        CoachType.AC -> AcPurple
    }
    Card(
        modifier = Modifier
            .width(if (coach.type == CoachType.ENGINE) 88.dp else 76.dp)
            .height(86.dp)
            .clickable { onCoach(coach) },
        shape = RoundedCornerShape(8.dp),
        border = if (important) BorderStroke(3.dp, Color.White.copy(alpha = alpha)) else null,
        colors = CardDefaults.cardColors(containerColor = color)
    ) {
        Column(Modifier.fillMaxSize().padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            Text(coach.code, color = Color.White, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
            if (important) Text("Stand Here", color = Color.White, style = MaterialTheme.typography.labelLarge, textAlign = TextAlign.Center)
        }
    }
}

@Composable
fun SettingsScreen(authViewModel: AuthViewModel, onBack: () -> Unit, onLoggedOut: () -> Unit) {
    var dark by remember { mutableStateOf(false) }
    var largeText by remember { mutableStateOf(true) }
    var showProfile by remember { mutableStateOf(false) }
    val profile by authViewModel.profile.collectAsState(initial = null)
    Scaffold(topBar = { NammaTopBar("Settings", onBack = onBack) }) { padding ->
        Column(Modifier.padding(padding).fillMaxSize().padding(18.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
            SettingRow(Icons.Default.DarkMode, "Dark mode", "Premium contrast theme") { Switch(dark, { dark = it }) }
            SettingRow(Icons.Default.Language, "Language", "Kannada + English") { FilterChip(selected = true, onClick = {}, label = { Text("KN/EN") }) }
            SettingRow(Icons.Default.TextFields, "Font size", "Elder-friendly large text") { Switch(largeText, { largeText = it }) }
            ElevatedCard(onClick = { showProfile = true }, shape = RoundedCornerShape(8.dp), modifier = Modifier.fillMaxWidth()) {
                Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Person, null, tint = RailwayBlue)
                    Spacer(Modifier.width(12.dp))
                    Column(Modifier.weight(1f)) {
                        Text(profile?.name ?: "Profile", fontWeight = FontWeight.Bold)
                        Text("Edit profile photo URI and details", color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.62f))
                    }
                    Text("Edit")
                }
            }
            ElevatedCard(shape = RoundedCornerShape(8.dp)) {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text("About Namma Platform", style = MaterialTheme.typography.titleLarge)
                    Text("Offline-first Kannada railway station guide for rural and small Karnataka stations.")
                    Text("Privacy: all account, session, favourites, and recent station data stays on this device.")
                }
            }
            Button(
                onClick = {
                    authViewModel.logout()
                    onLoggedOut()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Default.Logout, null)
                Spacer(Modifier.width(8.dp))
                Text("Logout")
            }
        }
    }
    if (showProfile && profile != null) {
        var name by remember(profile!!.id) { mutableStateOf(profile!!.name) }
        var phone by remember(profile!!.id) { mutableStateOf(profile!!.phone) }
        var photo by remember(profile!!.id) { mutableStateOf(profile!!.photoUri.orEmpty()) }
        AlertDialog(
            onDismissRequest = { showProfile = false },
            title = { Text("Edit Profile") },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    OutlinedTextField(name, { name = it }, label = { Text("Name") })
                    OutlinedTextField(phone, { phone = it }, label = { Text("Phone") })
                    OutlinedTextField(photo, { photo = it }, label = { Text("Profile photo URI") })
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    authViewModel.updateProfile(profile!!.id, name, phone, photo.ifBlank { null })
                    showProfile = false
                }) { Text("Save") }
            },
            dismissButton = { TextButton(onClick = { showProfile = false }) { Text("Cancel") } }
        )
    }
}

@Composable
private fun SettingRow(icon: androidx.compose.ui.graphics.vector.ImageVector, title: String, subtitle: String, trailing: @Composable () -> Unit) {
    ElevatedCard(shape = RoundedCornerShape(8.dp), modifier = Modifier.fillMaxWidth()) {
        Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, null, tint = RailwayBlue)
            Spacer(Modifier.width(12.dp))
            Column(Modifier.weight(1f)) {
                Text(title, fontWeight = FontWeight.Bold)
                Text(subtitle, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.62f))
            }
            trailing()
        }
    }
}

@Composable
private fun StationRow(station: Station, isFavorite: Boolean, onFavorite: () -> Unit, onClick: () -> Unit) {
    val haptic = LocalHapticFeedback.current
    ElevatedCard(onClick = {
        haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
        onClick()
    }, shape = RoundedCornerShape(8.dp), modifier = Modifier.fillMaxWidth()) {
        Row(Modifier.padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.DirectionsRailway, null, tint = RailwayBlue)
            Spacer(Modifier.width(12.dp))
            Column(Modifier.weight(1f)) {
                Text("${station.name} (${station.code})", fontWeight = FontWeight.Bold)
                Text("${station.kannadaName} • ${station.district} • ${station.platforms} platforms")
            }
            IconButton(onClick = onFavorite) {
                Icon(if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder, null, tint = if (isFavorite) CoachPink else RailwayBlue)
            }
        }
    }
}

@Composable
private fun AppScaffold(selected: String, onStations: () -> Unit, onSettings: () -> Unit, content: @Composable (androidx.compose.foundation.layout.PaddingValues) -> Unit) {
    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(selected = selected == "home", onClick = {}, icon = { Icon(Icons.Default.Home, null) }, label = { Text("Home") })
                NavigationBarItem(selected = selected == "stations", onClick = onStations, icon = { Icon(Icons.Default.Search, null) }, label = { Text("Stations") })
                NavigationBarItem(selected = selected == "settings", onClick = onSettings, icon = { Icon(Icons.Default.Settings, null) }, label = { Text("Settings") })
            }
        },
        content = content
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun NammaTopBar(title: String, onBack: (() -> Unit)? = null, action: (() -> Unit)? = null) {
    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            if (onBack != null) IconButton(onClick = onBack) { Icon(Icons.Default.ArrowBack, null) }
        },
        actions = {
            if (action != null) IconButton(onClick = action) { Icon(Icons.Default.Settings, null) }
        }
    )
}

@Composable
private fun PremiumBackground(content: @Composable () -> Unit) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Brush.linearGradient(listOf(Color(0xFF07111F), Color(0xFF0D47A1), Color(0xFF1565C0))))
    ) {
        content()
    }
}

@dagger.hilt.android.lifecycle.HiltViewModel
class TtsHolderViewModel @javax.inject.Inject constructor(
    val ttsController: NammaTtsController
) : androidx.lifecycle.ViewModel()
