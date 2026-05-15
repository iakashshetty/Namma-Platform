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

@kotlin.Metadata(mv = {2, 1, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/mindmatrix/nammaplatform/presentation/home/TtsHolderViewModel;", "Landroidx/lifecycle/ViewModel;", "ttsController", "Lcom/mindmatrix/nammaplatform/presentation/tts/NammaTtsController;", "<init>", "(Lcom/mindmatrix/nammaplatform/presentation/tts/NammaTtsController;)V", "getTtsController", "()Lcom/mindmatrix/nammaplatform/presentation/tts/NammaTtsController;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class TtsHolderViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.mindmatrix.nammaplatform.presentation.tts.NammaTtsController ttsController = null;
    
    @javax.inject.Inject()
    public TtsHolderViewModel(@org.jetbrains.annotations.NotNull()
    com.mindmatrix.nammaplatform.presentation.tts.NammaTtsController ttsController) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.mindmatrix.nammaplatform.presentation.tts.NammaTtsController getTtsController() {
        return null;
    }
}