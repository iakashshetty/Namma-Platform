package com.mindmatrix.nammaplatform.presentation.tts;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import dagger.hilt.android.qualifiers.ApplicationContext;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlinx.coroutines.flow.StateFlow;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {2, 1, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0011R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/mindmatrix/nammaplatform/presentation/tts/NammaTtsController;", "Landroid/speech/tts/TextToSpeech$OnInitListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "tts", "Landroid/speech/tts/TextToSpeech;", "_isReady", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_isSpeaking", "isReady", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "isSpeaking", "onInit", "", "status", "", "speak", "text", "", "stop", "app_debug"})
public final class NammaTtsController implements android.speech.tts.TextToSpeech.OnInitListener {
    @org.jetbrains.annotations.Nullable()
    private android.speech.tts.TextToSpeech tts;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isReady = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isSpeaking = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isReady = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isSpeaking = null;
    
    @javax.inject.Inject()
    public NammaTtsController(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isReady() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isSpeaking() {
        return null;
    }
    
    @java.lang.Override()
    public void onInit(int status) {
    }
    
    public final void speak(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    public final void stop() {
    }
}