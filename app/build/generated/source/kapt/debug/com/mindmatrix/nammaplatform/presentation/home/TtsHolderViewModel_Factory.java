package com.mindmatrix.nammaplatform.presentation.home;

import com.mindmatrix.nammaplatform.presentation.tts.NammaTtsController;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class TtsHolderViewModel_Factory implements Factory<TtsHolderViewModel> {
  private final Provider<NammaTtsController> ttsControllerProvider;

  public TtsHolderViewModel_Factory(Provider<NammaTtsController> ttsControllerProvider) {
    this.ttsControllerProvider = ttsControllerProvider;
  }

  @Override
  public TtsHolderViewModel get() {
    return newInstance(ttsControllerProvider.get());
  }

  public static TtsHolderViewModel_Factory create(
      Provider<NammaTtsController> ttsControllerProvider) {
    return new TtsHolderViewModel_Factory(ttsControllerProvider);
  }

  public static TtsHolderViewModel newInstance(NammaTtsController ttsController) {
    return new TtsHolderViewModel(ttsController);
  }
}
