package com.mindmatrix.nammaplatform.presentation.tts;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class NammaTtsController_Factory implements Factory<NammaTtsController> {
  private final Provider<Context> contextProvider;

  public NammaTtsController_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public NammaTtsController get() {
    return newInstance(contextProvider.get());
  }

  public static NammaTtsController_Factory create(Provider<Context> contextProvider) {
    return new NammaTtsController_Factory(contextProvider);
  }

  public static NammaTtsController newInstance(Context context) {
    return new NammaTtsController(context);
  }
}
