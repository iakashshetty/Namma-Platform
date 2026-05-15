package com.mindmatrix.nammaplatform.presentation.tts

import android.content.Context
import android.speech.tts.TextToSpeech
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.Locale
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Singleton
class NammaTtsController @Inject constructor(
    @ApplicationContext context: Context
) : TextToSpeech.OnInitListener {
    private var tts: TextToSpeech? = TextToSpeech(context, this)
    private val _isReady = MutableStateFlow(false)
    private val _isSpeaking = MutableStateFlow(false)
    val isReady: StateFlow<Boolean> = _isReady
    val isSpeaking: StateFlow<Boolean> = _isSpeaking

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val kannada = Locale("kn", "IN")
            val result = tts?.setLanguage(kannada) ?: TextToSpeech.LANG_MISSING_DATA
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                tts?.language = Locale.ENGLISH
            }
            _isReady.value = true
        }
    }

    fun speak(text: String) {
        if (_isReady.value) {
            _isSpeaking.value = true
            tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "namma-help-me")
        }
    }

    fun stop() {
        tts?.stop()
        _isSpeaking.value = false
    }
}
